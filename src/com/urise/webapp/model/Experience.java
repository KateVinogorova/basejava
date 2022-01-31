package com.urise.webapp.model;

import java.time.YearMonth;

public class Experience {
    private String place;
    private YearMonth dateFrom;
    private YearMonth dateTo;
    private String title;
    private String description;

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
    public int hashCode() {
        return place.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Experience) {
            return place.equals(((Experience) obj).getPlace()) && dateFrom.equals(((Experience) obj).getDateFrom())
                    && dateTo.equals(((Experience) obj).getDateTo());
        }
        return false;
    }

    @Override
    public String toString() {
        if (description != null) {
            return place + "\n" + dateFrom + " - " + dateTo + "\n" + title + "\n" + description + "\n\n";
        }
        return place + "\n" + dateFrom + " - " + dateTo + "\n" + title + "\n\n";
    }
}
