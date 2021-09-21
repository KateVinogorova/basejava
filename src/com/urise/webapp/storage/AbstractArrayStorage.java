package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    /**
     * Searches for the resume with the same uuid, updates if found
     */
    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("Resume with uuid " + resume.getUuid() + " not found");
        } else {
            storage[index] = resume;
        }
    }

    /**
     * Assigns null value to all elements of the storage
     */
    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    /**
     * Searches for the Resume with passed uuid and returns this Resume if found.
     * If Resume with passed uuid doesn't exist, displays information about it.
     *
     * @param uuid - unique String id
     * @return Resume with uuid equal to the passed parameter
     */
    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Uuid " + uuid + " not found");
            return null;
        }
        return storage[index];
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

    protected abstract int getIndex(String uuid);
}
