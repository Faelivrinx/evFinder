package com.mypieceofcode.evfinder.domain;

import com.mypieceofcode.evfinder.network.model.Coordinate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document
public class Event implements Recommendable{

    @Id
    private String id;
    private String title;
    private Long date;
    private Coordinate coordinate;
    private Map<String, Integer> profile;
    private String description;
    private String address;

    @Transient
    private double correlation;

    @java.beans.ConstructorProperties({"id", "title", "date", "coordinate", "profile", "description", "address", "correlation"})
    Event(String id, String title, Long date, Coordinate coordinate, Map<String, Integer> profile, String description, String address, double correlation) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.coordinate = coordinate;
        this.profile = profile;
        this.description = description;
        this.address = address;
        this.correlation = correlation;
    }

    public static EventBuilder builder() {
        return new EventBuilder();
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Long getDate() {
        return this.date;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public Map<String, Integer> getProfile() {
        return this.profile;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAddress() {
        return this.address;
    }

    public double getCorrelation() {
        return this.correlation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setProfile(Map<String, Integer> profile) {
        this.profile = profile;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCorrelation(double correlation) {
        this.correlation = correlation;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Event)) return false;
        final Event other = (Event) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$coordinate = this.getCoordinate();
        final Object other$coordinate = other.getCoordinate();
        if (this$coordinate == null ? other$coordinate != null : !this$coordinate.equals(other$coordinate))
            return false;
        final Object this$profile = this.getProfile();
        final Object other$profile = other.getProfile();
        if (this$profile == null ? other$profile != null : !this$profile.equals(other$profile)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        if (Double.compare(this.getCorrelation(), other.getCorrelation()) != 0) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $coordinate = this.getCoordinate();
        result = result * PRIME + ($coordinate == null ? 43 : $coordinate.hashCode());
        final Object $profile = this.getProfile();
        result = result * PRIME + ($profile == null ? 43 : $profile.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        final long $correlation = Double.doubleToLongBits(this.getCorrelation());
        result = result * PRIME + (int) ($correlation >>> 32 ^ $correlation);
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Event;
    }

    public String toString() {
        return "Event(id=" + this.getId() + ", title=" + this.getTitle() + ", date=" + this.getDate() + ", coordinate=" + this.getCoordinate() + ", profile=" + this.getProfile() + ", description=" + this.getDescription() + ", address=" + this.getAddress() + ", correlation=" + this.getCorrelation() + ")";
    }

    public static class EventBuilder {
        private String id;
        private String title;
        private Long date;
        private Coordinate coordinate;
        private Map<String, Integer> profile;
        private String description;
        private String address;
        private double correlation;

        public EventBuilder() {
        }

        public EventBuilder id(String id) {
            this.id = id;
            return this;
        }

        public EventBuilder title(String title) {
            this.title = title;
            return this;
        }

        public EventBuilder date(Long date) {
            this.date = date;
            return this;
        }

        public EventBuilder coordinate(Coordinate coordinate) {
            this.coordinate = coordinate;
            return this;
        }

        public EventBuilder profile(Map<String, Integer> profile) {
            this.profile = profile;
            return this;
        }

        public EventBuilder description(String description) {
            this.description = description;
            return this;
        }

        public EventBuilder address(String address) {
            this.address = address;
            return this;
        }

        public EventBuilder correlation(double correlation) {
            this.correlation = correlation;
            return this;
        }

        public Event build() {
            return new Event(id, title, date, coordinate, profile, description, address, correlation);
        }

        public String toString() {
            return "Event.EventBuilder(id=" + this.id + ", title=" + this.title + ", date=" + this.date + ", coordinate=" + this.coordinate + ", profile=" + this.profile + ", description=" + this.description + ", address=" + this.address + ", correlation=" + this.correlation + ")";
        }
    }
}
