package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveResume (Resume resume, int index) {
            index = Math.abs(index) - 1;
            if (storage[index] != null) {
                System.arraycopy(storage, index, storage, index + 1, size - index);
            }
            storage[index] = resume;
        }

    @Override
    protected void deleteResume(int index) {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}