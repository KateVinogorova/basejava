package com.urise.webapp.storage;

import org.junit.Ignore;
import org.junit.Test;

public class MapStorageTest extends AbstractArrayStorageTest {

    public MapStorageTest() {
        super(new MapUuidStorage());
    }

    @Ignore
    @Test
    public void saveOverflow() {
    }
}