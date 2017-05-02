package mirhusainov.itis.service;

import mirhusainov.itis.dao.FlightJPA;
import mirhusainov.itis.entities.FlightsEntity;

import java.util.List;

/**
 * Created by Ruslan on 27.04.2017.
 */
public class FlightService {
    private final FlightJPA flightJPA;

    public FlightService(FlightJPA flightJPA) {
        this.flightJPA = flightJPA;
    }


    public void addFlight(FlightsEntity flight){
        flightJPA.save(flight);
    }

    public FlightsEntity getOneFlightById(Long id){
        return flightJPA.findOne(id);
    }

    public List<FlightsEntity> getFlights(String depPoint,String destPoint){
        return flightJPA.findAllByDeparturePointIsAndDestinationPointIs(depPoint,destPoint);
    }

    public List<FlightsEntity> getFlights(String depPoint){
        return flightJPA.findAllByDeparturePointIs(depPoint);
    }

    public List<FlightsEntity> getFlights(){
        return flightJPA.findAll();
    }

    public void remove(Long id){
        flightJPA.delete(id);
    }
}
