package com.urise.webapp.model;

import java.util.*;

public class OrganizationSection extends AbstractSection {

    private List<Experience> experienceList;

    public OrganizationSection() {
        experienceList = new ArrayList<>();
    }

    public void addExperience(Experience experience) {
        experienceList.add(experience);
    }

    @Override
    public String toString() {
        for (Experience exp : experienceList) {
            System.out.println(exp.toString());
        }
        return "";
    }
}
