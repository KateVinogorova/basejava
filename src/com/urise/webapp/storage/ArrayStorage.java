package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size;

    /**
     * Searches for the resume with the same uuid, updates if found
     *
     * @param resume
     */
    public void update(Resume resume) {
        int index = indexOfResume(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
        } else {
            System.out.println("Resume with uuid " + resume.getUuid() + " not found");
        }
    }

    /**
     * Assigns null value to all elements of the storage
     */
    public void clear() {
        Arrays.fill(storage, 0, size - 1, null);
        size = 0;
    }

    /**
     * Adds new Resume to storage. If Resume with this uuid already exists,
     * displays information about it and does not add an object
     *
     * @param resume - Resume to be saved
     */
    public void save(Resume resume) {
        if (size == storage.length) {
            System.out.println("Storage overflow. Resume can not be saved.");
            return;
        } else if (indexOfResume(resume.getUuid()) >= 0) {
            System.out.println("Resume with uuid \"" + resume.getUuid() + "\" is already exist");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    /**
     * Searches for the Resume with passed uuid and returns this Resume if found.
     * If Resume with passed uuid doesn't exist, displays information about it.
     *
     * @param uuid - unique String id
     * @return Resume with uuid equal to the passed parameter
     */
    public Resume get(String uuid) {
        int index = indexOfResume(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            System.out.println("Uuid " + uuid + " not found");
            return null;
        }
    }

    /**
     * Deletes Resume with passed uuid from storage and shifts the following elements after deleted by index - 1
     * If Resume with passed uuid doesn't exist, displays information about it and did not make any changes
     *
     * @param uuid - unique String id
     */
    public void delete(String uuid) {
        int index = indexOfResume(uuid);
        if (index >= 0) {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
            size--;
        } else {
            System.out.println("Resume with uuid " + uuid + " not found");
        }
    }

    /**
     * @return array, which contains only Resumes in storage (without null)
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

    private int indexOfResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
