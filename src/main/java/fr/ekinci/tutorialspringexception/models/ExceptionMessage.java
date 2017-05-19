package fr.ekinci.tutorialspringexception.models;

import lombok.Builder;
import lombok.Data;

/**
 * Exception Message
 * @author Gokan EKINCI
 */
@Data
@Builder
public class ExceptionMessage {
	private String message;
	private String className;
	private String path;
	private String date;
}
