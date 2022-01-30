package com.urise.webapp.model;

import java.util.*;

public class ExperienceStorage extends Section {

    private Map<String, List<Experience>> experienceMap;

    public ExperienceStorage() {
        experienceMap = new LinkedHashMap<>();
    }

    public void addExperience(Experience experience) {
        String key = experience.getPlace();
        if (experienceMap.containsKey(key)) {
            experienceMap.get(key).add(experience);
        } else {
            List<Experience> listOfExperiences = new ArrayList<>();
            listOfExperiences.add(experience);
            experienceMap.put(key, listOfExperiences);
        }

    }

    public void updateExperience(Experience experience) {
    }

    public void deleteExperience(Experience experience) {
        experienceMap.remove(experience.getPlace());
    }

    @Override
    public void printSection() {
        for (Map.Entry<String, List<Experience>> entry : experienceMap.entrySet()) {
            System.out.println(entry.getKey());
            for (Experience e : entry.getValue()) {
                System.out.println(e);
            }
        }
    }
}
