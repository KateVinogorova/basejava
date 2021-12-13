package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    @Override
    public final void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public final void updateResume(Object searchKey, Resume resume) {
        int index = (int) searchKey;
        storage[index] = resume;
    }

    @Override
    public final void saveResume(Object searchKey, Resume resume) {
        int index = (int) searchKey;
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow. Resume can not be saved.", resume.getUuid());
        }
        doSave(resume, index);
        size++;
    }

    @Override
    public final Resume getResume(Object searchKey) {
        int index = (int) searchKey;
        return storage[index];
    }

    @Override
    public final void deleteResume(Object searchKey) {
        int index = (int) searchKey;
        doDelete(index);
        storage[size - 1] = null;
        size--;
    }

    /**
     * @return array, which contains only Resumes in storage (without null)
     */
    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    /**
     * Returns number of not null storage elements
     *
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    protected boolean exist(Resume resumeToFind) {
        return (int) getResumeKey(resumeToFind) >= 0;
    }

    protected abstract void doSave(Resume r, int index);

    protected abstract void doDelete(int index);
}
