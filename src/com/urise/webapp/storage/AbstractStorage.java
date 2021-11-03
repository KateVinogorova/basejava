package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

abstract class AbstractStorage implements Storage {

    /**
     * Searches for the resume with the same uuid, updates if found
     *
     * @param r - resume we want to insert into storage instead of the existing
     */
    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) throw new NotExistStorageException(r.getUuid());
        updateResume(r, index);
    }

    /**
     * Saves new Resume to storage if it isn't already there
     *
     * @param resume - Resume to save
     * @throws ExistStorageException if Resume is already exists
     */
    @Override
    public final void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        }
        saveResume(resume);
    }

    /**
     * Searches for the Resume with passed uuid and returns this Resume if found.
     * If Resume with passed uuid doesn't exist, displays information about it.
     *
     * @param uuid - unique id for searching of Resume
     * @return Resume with uuid equal to the passed parameter
     */
    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(index);
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
            throw new NotExistStorageException(uuid);
        }
        deleteResume(index);
    }

    public final int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return getResumeIndex(searchKey);
    }

    protected abstract int getResumeIndex(Resume searchKey);

    protected abstract void deleteResume(int index);

    protected abstract void updateResume(Resume r, int index);

    protected abstract void saveResume(Resume r);

    protected abstract Resume getResume(int index);
}
