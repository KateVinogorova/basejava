package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.Objects;

public class Position {
    private final YearMonth dateFrom;
    private final YearMonth dateTo;
    private final String title;
    private final String description;


    public static class Builder {

        private YearMonth dateFrom;
        private YearMonth dateTo;
        private String title;
        private String description;

        public Builder dateFrom(YearMonth from) {
            Objects.requireNonNull(from, "YearMonth from must not be null");
            dateFrom = from;
            return this;
        }

        public Builder dateTo(YearMonth to) {
            Objects.requireNonNull(to, "YearMonth to must not be null");
            dateTo = to;
            return this;
        }

        public Builder title(String posTitle) {
            Objects.requireNonNull(posTitle, "title must not be null");
            title = posTitle;
            return this;
        }

        public Builder description(String posDescription) {
            description = posDescription;
            return this;
        }

        public Position build() {
            return new Position(this);
        }
    }

    private Position(Builder builder) {
        dateFrom = builder.dateFrom;
        dateTo = builder.dateTo;
        title = builder.title;
        description = builder.description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return dateFrom.equals(position.dateFrom) && dateTo.equals(position.dateTo) && title.equals(position.title)
                && Objects.equals(description, position.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateFrom, dateTo, title, description);
    }
}
