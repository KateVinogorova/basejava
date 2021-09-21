package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {


    /**
     * Adds new Resume to storage. If Resume with this uuid already exists,
     * displays information about it and does not add an object
     *
     * @param resume - Resume to be saved
     */
    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            System.out.println("Resume is already exist");
        } else {
            index = Math.abs(index) - 1;
            if (storage[index] != null) {
                System.arraycopy(storage, index, storage, index + 1, size - index);
            }
            storage[index] = resume;
            size++;
        }
    }

    /**
     * Deletes Resume with passed uuid from storage and shifts the following elements
     * after deleted by index - 1
     * If Resume with passed uuid doesn't exist,
     * displays information about it and did not make any changes
     *
     * @param uuid - unique String id
     */
    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume with uuid " + uuid + " not found");
        } else {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
            size--;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
