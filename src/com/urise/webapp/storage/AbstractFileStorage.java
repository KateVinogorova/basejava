package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    protected void updateResume(File file, Resume resume) {
        if (isExist(file)) {
            try {
                doWrite(resume, file);
            } catch (IOException ioException) {
                throw new StorageException("Update resume IO error", file.getName(), ioException);
            }
        }
    }

    @Override
    protected void saveResume(File file, Resume resume) {
        try {
            file.createNewFile();
            doWrite(resume, file);
        } catch (IOException ioException) {
            throw new StorageException("Save resume IO error", file.getName(), ioException);
        }
    }

    @Override
    protected void deleteResume(File file) {
        if (isExist(file)) {
            file.delete();
        }
    }

    @Override
    protected Resume getResume(File file) {
        try {
            return doRead(file);
        } catch (IOException ioException) {
            throw new StorageException("Get resume IO error", file.getName(), ioException);
        }
    }

    @Override
    protected File getResumeKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected List<Resume> getStorageAsList() {
        List<Resume> listOfResumes = new ArrayList<>();
        if (directory.isDirectory()) {
            for (String s : Objects.requireNonNull(directory.list())) {
                try {
                    listOfResumes.add(doRead(new File(directory, s)));
                } catch (IOException ioException) {
                    throw new StorageException("Get storage as list IO Exception", directory + "/s", ioException);
                }
            }
        }
        return listOfResumes;
    }

    @Override
    public void clear() {
        String[] files = directory.list();
        if (files != null) {
            for (String s : files) {
                File currentFile = new File(directory, s);
                currentFile.delete();
            }
        }
    }

    @Override
    public int size() {
        return Objects.requireNonNull(directory.list()).length;
    }

    protected abstract void doWrite(Resume resume, File file) throws IOException;

    protected abstract Resume doRead(File file) throws IOException;
}
