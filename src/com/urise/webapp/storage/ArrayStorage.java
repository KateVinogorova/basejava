package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void doSave(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    protected void doDelete(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected Object getResumeKey(Resume searchKey) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(searchKey)) {
                return i;
            }
        }
        return -1;
    }
}
