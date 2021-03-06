package mirhusainov.itis.entities;

import javax.persistence.*;

/**
 * Created by Ruslan on 04.05.2017.
 */
@Entity
@Table(name = "flights", schema = "flight_schedule")
public class FlightEntity {
    private long flightId;
    private Integer number;
    private String planeType;
    private String departurePoint;
    private String destinationPoint;
    private CountryEntity countriesByCountryId;

    @Id
    @Column(name = "flight_id")
    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "plane_type")
    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    @Basic
    @Column(name = "departure_point")
    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    @Basic
    @Column(name = "destination_point")
    public String getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }


    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    public CountryEntity getCountriesByCountryId() {
        return countriesByCountryId;
    }

    public void setCountriesByCountryId(CountryEntity countriesByCountryId) {
        this.countriesByCountryId = countriesByCountryId;
    }
}
