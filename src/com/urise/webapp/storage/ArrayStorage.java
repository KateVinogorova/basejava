package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    /**
     * Adds new Resume to storage. If Resume with this uuid already exists,
     * displays information about it and does not add an object
     *
     * @param resume - Resume to be saved
     */
    @Override
    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            System.out.println("Resume with uuid \"" + resume.getUuid() + "\" is already exist");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow. Resume can not be saved.");
        } else {
            storage[size] = resume;
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
        if (index == -1) {
            System.out.println("Resume with uuid " + uuid + " not found");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
