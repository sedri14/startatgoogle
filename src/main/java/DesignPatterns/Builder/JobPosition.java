package DesignPatterns.Builder;

import java.time.LocalDate;

class JobPosition {

    //required
    private final LocalDate publishedDate;
    private final String title;
    private boolean isRemote;
    private int yearsOfExp;

    //optional
    private String description;
    private String location;
    private double salaryCap;

    public static class Builder {
        //Required Parameters
        private final LocalDate publishedDate;
        private final String title;
        private boolean isRemote;
        private int yearsOfExp;

        //Optional Parameters
        private String description;
        private String location = "Tel Aviv";
        private double salaryCap;

        public Builder(LocalDate publishedDate, String title, boolean isRemote, int yearsOfExp) {
            this.publishedDate = publishedDate;
            this.title = title;
            this.isRemote = isRemote;
            this.yearsOfExp = yearsOfExp;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder salaryCap(double salaryCap) {
            this.salaryCap = salaryCap;
            return this;
        }

        public JobPosition build() {
            return new JobPosition(this);
        }
    }

    private JobPosition (Builder builder) {
        this.publishedDate = builder.publishedDate;
        this.title = builder.title;
        this.isRemote = builder.isRemote;
        this.yearsOfExp = builder.yearsOfExp;
        this.description = builder.description;
        this.location = builder.location;
        this.salaryCap = builder.salaryCap;
    }

    @Override
    public String toString() {
        return "JobPosition{" +
                "publishedDate=" + publishedDate +
                ", title='" + title + '\'' +
                ", isRemote=" + isRemote +
                ", yearsOfExp=" + yearsOfExp +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", salaryCap=" + salaryCap +
                '}';
    }
}
