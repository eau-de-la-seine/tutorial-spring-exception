package fr.ekinci.tutorialspringexception.controllers;

import fr.ekinci.tutorialspringexception.exceptions.WrongAddressException;
import fr.ekinci.tutorialspringexception.models.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Gokan EKINCI
 */
@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionMessage> nullPointerExceptionHandler(HttpServletRequest request, NullPointerException exception) {
		ExceptionMessage message = ExceptionMessage.builder()
			.date(LocalDateTime.now().format(formatter))
			.path(request.getRequestURI().toString() + "?" + request.getQueryString())
			.className(exception.getClass().getName())
			.message("Tu veux éviter les null ? N'hésite pas à lire cet article: https://www.developpez.net/forums/blogs/473169-gugelhupf/b2944/java-astuces-eviter-nullpointerexception/")
			.build();
		return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(WrongAddressException.class)
	public ResponseEntity<ExceptionMessage> wrongAddressExceptionHandler(HttpServletRequest request, WrongAddressException exception) {
		ExceptionMessage message = ExceptionMessage.builder()
			.date(LocalDateTime.now().format(formatter))
			.path(request.getRequestURI().toString() + "?" + request.getQueryString())
			.className(exception.getClass().getName())
			.message(exception.getMessage())
			.build();
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionMessage> genericExceptionHandler(HttpServletRequest request, Exception exception) {
		ExceptionMessage message = ExceptionMessage.builder()
			.date(LocalDateTime.now().format(formatter))
			.path(request.getRequestURI().toString() + "?" + request.getQueryString())
			.className(exception.getClass().getName())
			.message(exception.getMessage())
			.build();
		return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
