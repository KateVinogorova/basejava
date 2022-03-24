package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection {
    private static final long serialVersionUID = 1L;

    private final List<String> sectionData;

    public ListSection() {
        sectionData = new ArrayList<>();
    }

    public ListSection(String... items) {
        this(Arrays.asList(items));
    }

    public ListSection(List<String> sectionData) {
        Objects.requireNonNull(sectionData, "sectionData must not be null");
        this.sectionData = sectionData;
    }

    public void addListItem(String listItem) {
        sectionData.add(listItem);
    }

    public List<String> getSectionData() {
        return sectionData;
    }

    @Override
    public String toString() {
        for (String s : sectionData) {
            System.out.println(" - " + s);
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;
        return sectionData.equals(that.sectionData);
    }

    @Override
    public int hashCode() {
        return sectionData.hashCode();
    }
}
