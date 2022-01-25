package com.urise.webapp.model;

import java.util.*;

/**
 * Initial resume class
 */

public class Resume {

    private final String uuid;
    private String fullName;
    private ArrayList<Contact> contacts;
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
        if (contacts == null) contacts = new ArrayList<>();
        contacts.add(new Contact(contactName, contactValue, contactLink));
    }

    public void printContacts() {
        for (Contact c : contacts) {
            System.out.println(c);
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

    static abstract class Section {
        public void printSection() {
        }
    }

    static class TextSection extends Section {
        private String description;

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public void printSection() {
            System.out.println(description);
        }
    }

    static class ListSection extends Section {
        private List<String> sectionData;

        ListSection() {
            sectionData = new ArrayList<String>();
        }

        public void addListItem(String listItem) {
            sectionData.add(listItem);
        }

        public List<String> getSectionData() {
            return sectionData;
        }

        @Override
        public void printSection() {
            for (String item : sectionData) {
                System.out.println(" - " + item);
            }
        }
    }

    static class MapSection extends Section {
        private Map<String, ArrayList<String>> sectionData;
        private ArrayList<String> data;

        MapSection() {
            sectionData = new LinkedHashMap<>();
        }

        public void addItem(String date, String company, String title, String description) {
            data = new ArrayList<>();
            data.add(0, company);
            data.add(1, title);
            data.add(2, description);
            sectionData.put(date, data);
        }

        @Override
        public void printSection() {
            for (Map.Entry<String, ArrayList<String>> entry : sectionData.entrySet()) {
                System.out.println(entry.getKey());
                for (String s : entry.getValue()) {
                    if (s != null) System.out.println(s);
                }
                System.out.println("");
            }
        }
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
