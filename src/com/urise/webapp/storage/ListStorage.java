package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void updateResume(Object searchKey, Resume resume) {
        int index = (int) searchKey;
        storage.add(index, resume);
    }

    @Override
    public void saveResume(Object searchKey, Resume resume) {
        storage.add(resume);
    }

    @Override
    public Resume getResume(Object searchKey) {
        int index = (int) searchKey;
        return storage.get(index);
    }

    @Override
    public void deleteResume(Object searchKey) {
        int index = (int) searchKey;
        storage.remove(index);
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    protected Object getResumeKey(Resume searchKey) {
        return storage.indexOf(searchKey);
    }

    @Override
    protected boolean isExist(Object key) {
        return (int) key >= 0;
    }
}
