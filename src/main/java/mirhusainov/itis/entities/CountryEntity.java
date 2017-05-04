package mirhusainov.itis.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruslan on 04.05.2017.
 */
@Entity
@Table(name = "countries", schema = "flight_schedule")
public class CountryEntity {
    private int countryId;
    private String name;
    private List<FlightEntity> flights;

    @OneToMany(mappedBy = "countriesByCountryId", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<FlightEntity> getFlight() {
        return flights;
    }

    public void setFlight(List<FlightEntity> flight) {
        this.flights = flight;
    }



    @Id
    @Column(name = "country_id")
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
