package com.urise.webapp.model;

import java.util.*;

/**
 * Initial resume class
 */

public class Resume {

    private final String uuid;
    private String fullName;
    private Map<String, Contact> contacts;
    public Map<SectionType, Section> sections = new LinkedHashMap<>();

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void addContact(String contactName, String contactValue, String contactLink) {
        if (contacts == null) contacts = new HashMap<>();
        Contact contact = new Contact(contactName, contactValue, contactLink);
        contacts.put(contactValue, contact);
    }

    public void printContacts() {
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            System.out.println(entry.getValue());
        }
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

    static class Contact {
        private String contactName;
        private String contactValue;
        private String contactLink;

        private Contact(String contactName, String contactValue, String contactLink) {
            this.contactName = contactName;
            this.contactValue = contactValue;
            this.contactLink = contactLink;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public void setContactValue(String contactValue) {
            this.contactValue = contactValue;
        }

        public void setContactLink(String contactLink) {
            this.contactLink = contactLink;
        }

        public String getContactName() {
            return contactName;
        }

        public String getContactValue() {
            return contactValue;
        }

        public String getContactLink() {
            return contactLink;
        }

        @Override
        public String toString() {
            return contactName + " " + contactValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Contact contact = (Contact) o;
            return Objects.equals(contactName, contact.contactName) && contactValue.equals(contact.contactValue) && Objects.equals(contactLink, contact.contactLink);
        }

        @Override
        public int hashCode() {
            return Objects.hash(contactName, contactValue, contactLink);
        }
    }
}
