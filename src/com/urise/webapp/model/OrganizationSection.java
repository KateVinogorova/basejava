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

    public void updateExperience(Experience experience) {
        int index = experienceList.indexOf(experience);
        if (index >= 0) experienceList.set(index, experience);
    }

    public void deleteExperience(Experience experience) {
        experienceList.remove(experience);
    }

    @Override
    public String toString() {
        return experienceList.toString();
    }
}
