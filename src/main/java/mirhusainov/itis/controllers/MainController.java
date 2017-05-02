package mirhusainov.itis.controllers;

import mirhusainov.itis.entities.CountriesEntity;
import mirhusainov.itis.entities.FlightsEntity;
import mirhusainov.itis.entities.UsersEntity;
import mirhusainov.itis.service.CountryService;
import mirhusainov.itis.service.FlightService;
import mirhusainov.itis.service.UserService;
import mirhusainov.itis.util.PointsDataHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruslan on 26.04.2017.
 */
@Controller
public class MainController {
    private final CountryService countryService;
    private final UserService userService;
    private final FlightService flightService;

    public MainController(CountryService countryService, UserService userService, FlightService flightService) {
        this.countryService = countryService;
        this.userService = userService;
        this.flightService = flightService;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        List<CountriesEntity> countries = countryService.getAll();
        model.addAttribute("countries", countries);
        return "home";
    }

    @RequestMapping(value = "/country={country_id}")
    public String certainCountry(@PathVariable("country_id") Long id, Model model) {
        CountriesEntity country = countryService.getById(id);
        model.addAttribute("country_id", id);
        model.addAttribute("country_name", country.getName());

        return "flights-schedule";
    }

    @RequestMapping(value = "/country={country_id}/flight-schedule", method = RequestMethod.POST)
    public String certainSchedule(@ModelAttribute("points") @Valid PointsDataHolder holder, Model model, @PathVariable("country_id") Long id) {
        List<FlightsEntity> flights;
        String depPoint = holder.getDeparturePoint();
        String destPoint = holder.getDestinationPoint();

        if (holder.getDestinationPoint() != null) {
            if (holder.getDestinationPoint() != null) {
                flights = flightService.getFlights(depPoint, destPoint);
            } else {
                flights = flightService.getFlights(depPoint);
            }
        } else {
            flights = flightService.getFlights();
        }
        model.addAttribute("country_id", id);
        model.addAttribute("flights", flights);
        return "flight-list";
    }

    @RequestMapping(value = "/country=${country_id}/flight-schedule/flight-list/flight=${flight_id}", method = RequestMethod.GET)
    public String certainFlight(@PathVariable("flight_id") Long flight_id, @PathVariable("country_id") Long country_id, Model model) {
        FlightsEntity flight = flightService.getOneFlightById(flight_id);
        model.addAttribute("flight", flight);
        return "flight";
    }

    private UsersEntity getCurrentUser(Model model) {
        UsersEntity user = (UsersEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ArrayList<GrantedAuthority> authorities = (ArrayList<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        model.addAttribute("isAdmin", false);
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                model.addAttribute("isAdmin", true);
            }
        }
        model.addAttribute("currentUser", user);
        return user;
    }
}
