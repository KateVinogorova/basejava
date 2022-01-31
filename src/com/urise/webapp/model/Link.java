package com.urise.webapp.model;

import java.util.Objects;

class Link {
    private String name;
    private String url;

    Link(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(name, link.getName()) && Objects.equals(url, link.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }
}
