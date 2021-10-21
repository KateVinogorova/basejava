package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public abstract class AbstractArrayStorageTest {
    Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void update() throws NotExistStorageException {
        Resume newResume = new Resume(UUID_3);
        storage.update(newResume);
        assertEquals(newResume, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume("uuid5"));
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void get() throws NotExistStorageException {
        Resume r = new Resume(UUID_4);
        storage.save(r);
        assertEquals(r, storage.get(UUID_4));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void getAll() {
        Resume[] testArray = new Resume[3];
        testArray[0] = new Resume(UUID_1);
        testArray[1] = new Resume(UUID_2);
        testArray[2] = new Resume(UUID_3);

        assertArrayEquals(testArray, storage.getAll());
        assertEquals(3, storage.size());
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test
    public void save() throws StorageException {
        Resume r = new Resume(UUID_4);
        storage.save(r);
        assertEquals(r, storage.get(UUID_4));
        assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(new Resume(UUID_1));
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        for (int i = 3; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
            try {
                storage.save(new Resume());
            } catch (StorageException exception) {
                fail("Exception is thrown before overflow");
            }
        }
        storage.save(new Resume());
    }

    @Test
    public void delete() throws NotExistStorageException {
        storage.delete(UUID_3);
        assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }
}