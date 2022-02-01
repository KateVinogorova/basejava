package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class ListSection extends AbstractSection {
    private List<String> sectionData;

    public ListSection() {
        sectionData = new ArrayList<>();
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
}
