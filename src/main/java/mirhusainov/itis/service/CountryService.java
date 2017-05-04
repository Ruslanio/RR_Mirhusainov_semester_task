
package mirhusainov.itis.service;

import mirhusainov.itis.dao.CountryJPA;
import mirhusainov.itis.entities.CountryEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ruslan on 27.04.2017.
 */
@Service
@Transactional
public class CountryService {
    private final CountryJPA countryJPA;

    public CountryService(CountryJPA countryJPA) {
        this.countryJPA = countryJPA;
    }


    public void add(CountryEntity country) {
        countryJPA.save(country);
    }


    public CountryEntity getById(Long id) {
        return countryJPA.findOne(id);
    }


    public List<CountryEntity> getAll() {
        return countryJPA.findAll();
    }

    public void remove(Long id) {
        countryJPA.delete(id);
    }
}