package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.Objects;

public class Experience {
    private String place;
    private YearMonth dateFrom;
    private YearMonth dateTo;
    private String title;
    private String description;
    Link website;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public YearMonth getDateFrom() {
        return dateFrom;
    }

    public void setDates(YearMonth from, YearMonth to) {
        dateFrom = from;
        dateTo = to;
    }

    public YearMonth getDateTo() {
        return dateTo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return Objects.equals(place, that.getPlace()) && Objects.equals(dateFrom, that.getDateFrom())
                && Objects.equals(dateTo, that.getDateTo()) && Objects.equals(title, that.getTitle())
                && description.equals(that.getDescription()) && Objects.equals(website, that.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place, dateFrom, dateTo, title, description, website);
    }

    @Override
    public String toString() {
        String output = place + "\n" + dateFrom + " - " + dateTo + "\n" + title + "\n";
        if (description != null) {
            output += description + "\n";
        }
        return output;
    }
}
