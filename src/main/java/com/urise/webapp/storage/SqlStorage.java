package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.sql.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlStorage implements Storage {
    public final ConnectionFactory connectionFactory;

    public SqlStorage(String dbUrl, String dbUser, String dbPassword) {
        connectionFactory = () -> DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    @Override
    public void clear() {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement prepareStatement = conn.prepareStatement("DELETE FROM resume")) {
            prepareStatement.execute();
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void update(Resume r) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement prepareStatement = conn.prepareStatement(
                     "UPDATE resume SET uuid = ?, full_name = ? WHERE uuid = ?")) {
            prepareStatement.setString(1, r.getUuid());
            prepareStatement.setString(2, r.getFullName());
            prepareStatement.setString(3, r.getUuid());
            prepareStatement.execute();
            if (prepareStatement.executeUpdate() == 0) {
                throw new NotExistStorageException(r.getUuid());
            }
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void save(Resume r) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO resume (uuid, full_name) VALUES (?, ?)")) {
            prepareStatement.setString(1, r.getUuid());
            prepareStatement.setString(2, r.getFullName());
            prepareStatement.execute();
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                throw new ExistStorageException(null);
            } else {
                throw new StorageException(e);
            }

        }
    }

    @Override
    public Resume get(String uuid) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM resume WHERE uuid =?")) {
            prepareStatement.setString(1, uuid);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (!resultSet.next()) {
                throw new NotExistStorageException(uuid);
            }
            Resume resume = new Resume(uuid, resultSet.getString("full_name"));
            return resume;
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void delete(String uuid) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement prepareStatement = conn.prepareStatement("DELETE FROM resume WHERE uuid =?")) {
            prepareStatement.setString(1, uuid);
            if (prepareStatement.executeUpdate() == 0) {
                throw new NotExistStorageException(uuid);
            }
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = new ArrayList<>();
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement prepareStatement = conn.prepareStatement(
                     "SELECT * FROM resume ORDER BY full_name ASC, uuid ASC")) {
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                String uuid = resultSet.getString("uuid").trim();
                String fullName = resultSet.getString("full_name");
                list.add(new Resume(uuid, fullName));
            }
        } catch (SQLException e) {
            throw new StorageException(e);
        }
        return list;
    }

    @Override
    public int size() {
        return getAllSorted().size();
    }
}
