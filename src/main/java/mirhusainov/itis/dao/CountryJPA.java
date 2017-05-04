package mirhusainov.itis.dao;

import mirhusainov.itis.entities.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ruslan on 26.04.2017.
 */
public interface CountryJPA extends JpaRepository<CountryEntity,Long> {
}
