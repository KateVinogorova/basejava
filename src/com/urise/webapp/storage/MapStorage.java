package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void updateResume(Object searchKey, Resume resume) {
        String key = (String) searchKey;
        storage.replace(key, resume);
    }

    @Override
    protected void saveResume(Object searchKey, Resume resume) {
        String key = (String) searchKey;
        storage.put(key, resume);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        String key = (String) searchKey;
        return storage.get(key);
    }

    @Override
    protected void deleteResume(Object searchKey) {
        String key = (String) searchKey;
        storage.remove(key);
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Object getResumeKey(Resume searchKey) {
        return searchKey.getUuid();
    }

    @Override
    protected boolean exist(Resume resumeToFind) {
        return storage.containsValue(resumeToFind);
    }

}
