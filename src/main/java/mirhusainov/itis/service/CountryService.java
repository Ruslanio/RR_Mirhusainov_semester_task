package mirhusainov.itis.service;

import mirhusainov.itis.dao.CountryJPA;
import mirhusainov.itis.entities.CountriesEntity;
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

    public void add(CountriesEntity country){
        countryJPA.save(country);
    }

    public CountriesEntity getById(Long id){
        return countryJPA.findOne(id);
    }

    public List<CountriesEntity> getAll(){
        return countryJPA.findAll();
    }

    public void remove(Long id){
        countryJPA.delete(id);
    }
}
