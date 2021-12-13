package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

abstract class AbstractStorage implements Storage {

    /**
     * Searches for the resume with the same uuid, updates if found
     *
     * @param resume - resume we want to insert into storage instead of the existing
     */
    @Override
    public void update(Resume resume) {
        Object searchKey = getKeyNotExist(resume.getUuid());
        updateResume(searchKey, resume);
    }

    /**
     * Saves new Resume to storage if it isn't already there
     *
     * @param resume - Resume to save
     * @throws ExistStorageException if Resume is already exists
     */
    @Override
    public final void save(Resume resume) {
        Object searchKey = getKeyExist(resume.getUuid());
        saveResume(searchKey, resume);
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
        Object searchKey = getKeyNotExist(uuid);
        return getResume(searchKey);
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
        Object searchKey = getKeyNotExist(uuid);
        deleteResume(searchKey);
    }

    private Object getKeyExist(String uuid) {
        Resume resumeToFind = new Resume(uuid);

        if (exist(resumeToFind)) {
            throw new ExistStorageException(uuid);
        }
        return getResumeKey(resumeToFind);
    }

    private Object getKeyNotExist(String uuid) {
        Resume resumeToFind= new Resume(uuid);
        if (!exist(resumeToFind)) {
            throw new NotExistStorageException(uuid);
        }
        return getResumeKey(resumeToFind);
    }

    protected abstract void updateResume(Object searchKey, Resume resume);

    protected abstract void saveResume(Object searchKey, Resume resume);

    protected abstract void deleteResume(Object searchKey);

    protected abstract Resume getResume(Object searchKey);

    protected abstract Object getResumeKey(Resume resumeToFind);

    protected abstract boolean exist(Resume resumeToFind);
}
