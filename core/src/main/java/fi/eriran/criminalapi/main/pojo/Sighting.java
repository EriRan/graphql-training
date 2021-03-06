package fi.eriran.criminalapi.main.pojo;

import javax.persistence.Column;
import java.time.OffsetDateTime;

public class Sighting {
    @Column(name = "id")
    private Integer id;
    @Column(name = "area")
    private String area;
    @Column(name = "address")
    private String address;
    @Column(name = "description")
    private String description;
    @Column(name = "time_of_sighting")
    private OffsetDateTime timeOfSighting;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getTimeOfSighting() {
        return timeOfSighting;
    }

    public void setTimeOfSighting(OffsetDateTime timeOfSighting) {
        this.timeOfSighting = timeOfSighting;
    }
}
