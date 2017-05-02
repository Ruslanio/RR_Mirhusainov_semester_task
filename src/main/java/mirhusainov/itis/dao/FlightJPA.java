package mirhusainov.itis.dao;

import mirhusainov.itis.entities.FlightsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ruslan on 26.04.2017.
 */
public interface FlightJPA extends JpaRepository<FlightsEntity,Long> {

    List<FlightsEntity> findAllByDeparturePointIsAndDestinationPointIs(String departurePoint, String destinationPoint);

    List<FlightsEntity> findAllByDeparturePointIs(String departurePoint);
}
