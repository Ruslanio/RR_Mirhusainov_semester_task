package mirhusainov.itis.controllers;

import mirhusainov.itis.entities.CountryEntity;
import mirhusainov.itis.entities.FlightEntity;
import mirhusainov.itis.service.CountryService;
import mirhusainov.itis.service.FlightService;
import mirhusainov.itis.util.NewCountryDataHolder;
import mirhusainov.itis.util.NewFlightDataHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Ruslan on 03.05.2017.
 */
@Controller
public class AdminController {

    private final CountryService countryService;
    private final FlightService flightService;

    public AdminController(CountryService countryService, FlightService flightService) {
        System.out.println("Admin Controller Inizialazed");
        this.countryService = countryService;
        this.flightService = flightService;
    }

    // adders

    @RequestMapping(value = "/admin/new-country", method = RequestMethod.GET)
    public String addCountry(Model model){
        model.addAttribute("country_holder",new NewCountryDataHolder());
        return "country-form-new";
    }
    @RequestMapping(value = "/admin/new-country", method = RequestMethod.POST)
    public String addCountry(@ModelAttribute("new_country") @Valid NewCountryDataHolder holder){
        CountryEntity country = new CountryEntity();
        country.setName(holder.getName());
        if (!countryService.getAll().contains(country))
            countryService.add(country);
        return "redirect:/home";
    }

    @RequestMapping(value = "/admin/country={country_id}/new-flight", method = RequestMethod.GET)
    public String addFlight(Model model, @PathVariable("country_id") String country_id){
        model.addAttribute("country_id",country_id);
        model.addAttribute("flight_holder", new NewFlightDataHolder());
        return "flight-form-new";
    }

    @RequestMapping(value = "/admin/country={country_id}/new-flight", method = RequestMethod.POST)
    public String addFlight(@ModelAttribute("new_flight") @Valid NewFlightDataHolder holder, @PathVariable("country_id") String country_id){
        FlightEntity flight = new FlightEntity();
        flight.setNumber(holder.getNumber());
        flight.setPlaneType(holder.getPlaneType());
        flight.setDeparturePoint(holder.getDepPoint());
        flight.setDestinationPoint(holder.getDestPoint());

        if(!flightService.getFlights().contains(flight)){
            flightService.addFlight(flight);
        }
        return "redirect:/country={country_id}";
    }

    // deleters

    @RequestMapping(value = "/admin/delete-country", method = RequestMethod.POST)
    public String deleteCountry(@RequestParam("deleted_id") Long deleted_id){
        countryService.remove(deleted_id);
        return "redirect:/home";
    }

    @RequestMapping(value = "admin/country={country_id}/delete-flight", method = RequestMethod.POST)
    public String deleteFlight(@RequestParam("deleted_id") Long deleted_id, @PathVariable("country_id") String country_id){
        flightService.remove(deleted_id);
        return "redirect:/country={country_id}";
    }
}
