package fr.ekinci.tutorialspringexception.models;

import lombok.Builder;
import lombok.Data;

/**
 * A simple POJO class for trains project
 *
 * @author Gokan EKINCI
 */
@Data
@Builder
public class ItineraryItem {
	private String mode;
	private String departureStation;
	private String direction;
	private int nbStations;
	private int duration;
	private String arrivalStation;
}
