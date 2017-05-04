package mirhusainov.itis.dao;

import mirhusainov.itis.entities.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ruslan on 26.04.2017.
 */
public interface FlightJPA extends JpaRepository<FlightEntity,Long> {

    List<FlightEntity> findAllByDeparturePointIsAndDestinationPointIs(String departurePoint, String destinationPoint);

    List<FlightEntity> findAllByDeparturePointIs(String departurePoint);
}
