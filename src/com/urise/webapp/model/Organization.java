package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Organization {

    private final Link link;
    private final List<Position> positionList = new ArrayList<>();

    public Organization(Link link) {
        Objects.requireNonNull(link, "company link must not be null");
        this.link = link;
    }

    public void addPosition(Position position) {
        positionList.add(position);
    }

    public Link getLink() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionList, link);
    }

    @Override
    public String toString() {
        System.out.println(link);
        for (Position p : positionList) {
            System.out.println(p);
        }
        return "";
    }
}
