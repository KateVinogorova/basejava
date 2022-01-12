package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

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

    @Override
    public int size() {
        return size;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (int) searchKey >= 0;
    }

    protected abstract void doSave(Resume r, int index);

    protected abstract void doDelete(int index);

    @Override
    protected List<Resume> getStorageAsList() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }
}
