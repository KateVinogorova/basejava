package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class OrganizationSection extends AbstractSection {

    private final List<Organization> organizations = new ArrayList<>();

    public void addOrganisation(Organization organization) {
        organizations.add(organization);
    }

    @Override
    public String toString() {
        for (Organization o : organizations) {
            o.toString();
        }
        return "";
    }
}
