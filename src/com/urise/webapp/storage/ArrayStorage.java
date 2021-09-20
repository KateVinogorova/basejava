package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    /**
     * Assigns null value to all elements of the storage
     */
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    /**
     * Searches for the resume with the same uuid, updates if found
     *
     * @param resume
     */
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("Resume with uuid " + resume.getUuid() + " not found");
        } else {
            storage[index] = resume;
        }
    }

    /**
     * Adds new Resume to storage. If Resume with this uuid already exists,
     * displays information about it and does not add an object
     *
     * @param resume - Resume to be saved
     */
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
     * Deletes Resume with passed uuid from storage and shifts the following elements after deleted by index - 1
     * If Resume with passed uuid doesn't exist, displays information about it and did not make any changes
     *
     * @param uuid - unique String id
     */
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

    /**
     * @return array, which contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
