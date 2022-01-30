package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class ListSection extends Section {
    private List<String> sectionData;

    public ListSection() {
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
