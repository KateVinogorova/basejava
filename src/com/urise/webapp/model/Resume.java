package com.urise.webapp.model;

/**
 * Initial resume class
 */

public class Resume implements Comparable<Resume> {

    // Unique identifier
    private String uuid;

    /**
     * Returns uuid of the current Resume instance
     *
     * @return
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets uuid value for the current Resume instance
     *
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Resume resume = (Resume) o;
        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public int compareTo(Resume o) {
        return uuid.compareTo(o.uuid);
    }
}
