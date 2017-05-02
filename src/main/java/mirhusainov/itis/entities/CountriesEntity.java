package mirhusainov.itis.entities;

import javax.persistence.*;

/**
 * Created by Ruslan on 27.04.2017.
 */
@Entity
@Table(name = "countries", schema = "flight_schedule")
public class CountriesEntity {
    private int countryId;
    private String name;

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
