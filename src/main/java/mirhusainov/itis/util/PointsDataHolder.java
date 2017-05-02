package mirhusainov.itis.util;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Ruslan on 02.05.2017.
 */
public class PointsDataHolder {

    @NotBlank(message = "You have to choose your departure point")
    private String departurePoint;

    private String destinationPoint;

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }
}
