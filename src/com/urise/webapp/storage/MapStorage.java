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
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected int getResumeIndex(Resume searchKey) {
        if (storage.containsValue(searchKey)) {
            return 1;
        }
        return -1;
    }

    @Override
    protected void deleteResume(int index, String key) {
        storage.remove(key);
    }

    @Override
    protected void updateResume(Resume r, int index) {
        storage.replace(r.getUuid(), r);
    }

    @Override
    protected void saveResume(Resume r, int index) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume getResume(int index, String key) {
        return storage.get(key);
    }
}
