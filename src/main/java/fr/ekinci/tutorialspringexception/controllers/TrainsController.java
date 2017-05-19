package fr.ekinci.tutorialspringexception.controllers;

import fr.ekinci.tutorialspringexception.exceptions.WrongAddressException;
import fr.ekinci.tutorialspringexception.models.ExceptionMessage;
import fr.ekinci.tutorialspringexception.models.ItineraryItem;
import fr.ekinci.tutorialspringexception.utils.RandomUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gokan EKINCI
 */
@RestController
public class TrainsController {

	@RequestMapping(value = "/itinerary", method = RequestMethod.GET)
	public List<ItineraryItem> getItinerary(
		@RequestParam("departure") String departure,
		@RequestParam("destination") String destination
	) {
		List<ItineraryItem> itinerary = getMock(departure, destination);
		return itinerary;
	}

	/**
	 * A simple mock
	 *
	 * @param departure		Departure information
	 * @param destination	Destination information
	 * @return				Itinerary
	 */
	public List<ItineraryItem> getMock(String departure, String destination) {
		List<ItineraryItem> itineraryItems = new ArrayList<>();
		itineraryItems.add(
			ItineraryItem.builder()
				.mode("Métro Ligne 13")
				.departureStation("Mairie de Clichy")
				.direction("Châtillon Montrouge")
				.nbStations(9)
				.duration(14)
				.arrivalStation("Invalides")
				.build()
		);
		itineraryItems.add(
			ItineraryItem.builder()
				.mode("RER C")
				.departureStation("Invalides")
				.direction("Gare d'Austerlitz")
				.nbStations(2)
				.duration(6)
				.arrivalStation("Saint-Michel Notre-Dame")
				.build()
		);

		switch (RandomUtils.between(0, 3)) {
			case 0 : return itineraryItems;
			case 1 : throw new WrongAddressException("L'adresse de départ est incorrecte");
			case 2 : throw new WrongAddressException("L'adresse de destination est incorrecte");
			default : throw new NullPointerException();
		}
	}

}
