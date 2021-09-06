package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    /**
     * Searches for the resume with the same uuid, updates if found
     *
     * @param resume
     */
    public void update(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(resume.getUuid())) {
                storage[i] = resume;
                System.out.println("Storage updated");
                return;
            }
        }
        System.out.println("com.urise.webapp.model.Resume with uuid " + resume.getUuid() + " was not found");
    }

    /**
     * Assigns null value to all elements of the storage
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    /**
     * Adds new com.urise.webapp.model.Resume to storage. If com.urise.webapp.model.Resume with this uuid already exists,
     * displays information about it and does not add an object
     *
     * @param resume - com.urise.webapp.model.Resume to be saved
     */
    public void save(Resume resume) {
        if (size == storage.length) {
            System.out.println("Storage overflow");
            return;
        }
        if (!isExist(resume)) {
            storage[size] = resume;
            size++;
        }
    }

    /**
     * Searches for the com.urise.webapp.model.Resume with passed uuid and returns this com.urise.webapp.model.Resume if found.
     * If com.urise.webapp.model.Resume with passed uuid doesn't exist, displays information about it.
     *
     * @param uuid - unique String id
     * @return com.urise.webapp.model.Resume with uuid equal to the passed parameter
     */
    public Resume get(String uuid) {
        Resume targetResume = null;
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    return storage[i];
                } else if (i == size - 1) {
                    System.out.println("Uuid " + uuid + " was not found");
                }
            }
        }
        return targetResume;
    }

    /**
     * Deletes com.urise.webapp.model.Resume with passed uuid from storage and shifts the following elements after deleted by index - 1
     * If com.urise.webapp.model.Resume with passed uuid doesn't exist, displays information about it and did not make any changes
     *
     * @param uuid - unique String id
     */
    public void delete(String uuid) {
        if (!isEmpty() && isExist(uuid)) {
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                System.arraycopy(storage, index + 1, storage, index, size - index - 1);
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    /**
     * @return number of not null storage elements
     */
    public int size() {
        return size;
    }

    /**
     * Checks if com.urise.webapp.model.Resume is in storage
     *
     * @param resume
     * @return true if resume is already exist, false - if resume is not found in storage
     */
    private boolean isExist(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(resume.getUuid())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if com.urise.webapp.model.Resume is in storage
     *
     * @param uuid
     * @return true if resume is already exist, false - if resume is not found in storage
     */
    private boolean isExist(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the storage is empty
     *
     * @return true if storage is empty, false - id storage has one or more element
     */
    private boolean isEmpty() {
        if (size == 0) {
            System.out.println("Storage is empty");
            return true;
        }
        return false;
    }
}
