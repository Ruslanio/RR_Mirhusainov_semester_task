package mirhusainov.itis.service;

import mirhusainov.itis.dao.FlightJPA;
import mirhusainov.itis.entities.FlightEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ruslan on 27.04.2017.
 */
@Service
@Transactional
public class FlightService {
    private final FlightJPA flightJPA;

    public FlightService(FlightJPA flightJPA) {
        this.flightJPA = flightJPA;
    }


    public void addFlight(FlightEntity flight){
        flightJPA.save(flight);
    }

    public FlightEntity getOneFlightById(Long id){
        return flightJPA.findOne(id);
    }

    public List<FlightEntity> getFlights(String depPoint,String destPoint){
        return flightJPA.findAllByDeparturePointIsAndDestinationPointIs(depPoint,destPoint);
    }

    public List<FlightEntity> getFlights(String depPoint){
        return flightJPA.findAllByDeparturePointIs(depPoint);
    }

    public List<FlightEntity> getFlights(){
        return flightJPA.findAll();
    }

    public void remove(Long id){
        flightJPA.delete(id);
    }
}