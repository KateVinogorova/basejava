package com.urise.webapp.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlHelper {
    ConnectionFactory cf;

    public SqlHelper(ConnectionFactory cf) {
        this.cf = cf;
    }

    public void execute(String sql) {
        execute(sql, PreparedStatement::execute);
    }

    public <T> T execute(String sql, SqlExecutor<T> executor) {
        try (Connection conn = cf.getConnection(); PreparedStatement prepareStatement = conn.prepareStatement(sql)) {
            return executor.execute(prepareStatement);
        } catch (SQLException e) {
            throw ExceptionUtil.convertException(e);
        }
    }
}
