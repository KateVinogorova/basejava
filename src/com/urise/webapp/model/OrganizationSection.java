package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizationSection extends AbstractSection {

    private final Map<Organization, List<Position>> positions = new HashMap<>();

    public void addOrganisation(Organization organization, Position position) {
        if (positions.containsKey(organization)) {
            positions.get(organization).add(position);
        } else {
            List<Position> list = new ArrayList<>();
            list.add(position);
            positions.put(organization, list);
        }
    }

    @Override
    public String toString() {
        for (Map.Entry<Organization, List<Position>> entry : positions.entrySet()) {
            System.out.println(entry.getKey());
            for (Position position : entry.getValue()) {
                System.out.println(position);
            }
        }
        return "";
    }
}
