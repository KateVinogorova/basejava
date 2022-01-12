package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;

abstract class AbstractStorage implements Storage {

    public Comparator<Resume> GET_ALL_COMPARATOR = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    /**
     * Searches for the resume with the same uuid, updates if found
     *
     * @param resume - resume we want to insert into storage instead of the existing
     */
    @Override
    public void update(Resume resume) {
        Object searchKey = getKeyExist(resume.getUuid());
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
        Object searchKey = getKeyNotExist(resume.getUuid());
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
        Object searchKey = getKeyExist(uuid);
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
        Object searchKey = getKeyExist(uuid);
        deleteResume(searchKey);
    }

    private Object getKeyNotExist(String uuid) {
        Object key = getResumeKey(uuid);
        if (isExist(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    private Object getKeyExist(String uuid) {
        Object key = getResumeKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = getStorageAsList();
        list.sort(GET_ALL_COMPARATOR);
        return list;
    }

    protected abstract void updateResume(Object searchKey, Resume resume);

    protected abstract void saveResume(Object searchKey, Resume resume);

    protected abstract void deleteResume(Object searchKey);

    protected abstract Resume getResume(Object searchKey);

    protected abstract Object getResumeKey(String uuid);

    protected abstract boolean isExist(Object searchKey);

    protected abstract List<Resume> getStorageAsList();
}
