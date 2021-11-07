package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MapStorageTest extends AbstractArrayStorageTest {
    public MapStorageTest() {
        super(new MapStorage());
    }

    @Test
    public void getAll() {
        Resume[] testArray = new Resume[3];
        testArray[0] = new Resume("uuid1");
        testArray[1] = new Resume("uuid2");
        testArray[2] = new Resume("uuid3");
        Resume[] storageArray = storage.getAll();
        Arrays.sort(storageArray);

        assertArrayEquals(testArray, storageArray);
        assertEquals(3, storage.size());
    }

    @Ignore
    @Test
    public void saveOverflow() {
    }
}