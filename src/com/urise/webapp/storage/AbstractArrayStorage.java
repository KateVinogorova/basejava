package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    /**
     * Returns number of not null storage elements
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Searches for the Resume with passed uuid and returns this Resume if found.
     * If Resume with passed uuid doesn't exist, displays information about it.
     *
     * @param uuid - unique String id
     * @return Resume with uuid equal to the passed parameter
     */
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Uuid " + uuid + " not found");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);
}
