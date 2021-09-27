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
    public final void clear() {
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
    public final Resume get(String uuid) {
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

    /**
     * Adds new Resume to storage. If Resume with this uuid already exists,
     * displays information about it and does not add an object
     *
     * @param resume - Resume to be saved
     */
    @Override
    public final void save (Resume resume) {
        String uuid = resume.getUuid();
        int index = getIndex(uuid);
        if (index >= 0) {
            System.out.println("Resume with uuid \"" + uuid + "\" is already exist");
        }
        if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow. Resume can not be saved.");
        }
        else {
            saveResume(resume, index);
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
    public final void delete (String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume with uuid " + uuid + " not found");
        }
        deleteResume(index);
        size--;
    }

    /**
     * Adds new Resume to storage. If Resume with this uuid already exists,
     * displays information about it and does not add an object
     *
     * @param resume - Resume to be saved
     * @param index - index for saving to sorted array
     */
    protected abstract void saveResume (Resume resume, int index);

    protected abstract void deleteResume (int index);

    protected abstract int getIndex(String uuid);


}