package com.urise.webapp.model;

/**
 * Initial resume class
 */

public class Resume {

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
    public String toString() {
        return uuid;
    }
}
