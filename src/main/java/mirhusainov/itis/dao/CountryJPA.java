package mirhusainov.itis.dao;

import mirhusainov.itis.entities.Country;
import mirhusainov.itis.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ruslan on 26.04.2017.
 */
public interface CountryJPA extends JpaRepository<Country,Long> {
}
