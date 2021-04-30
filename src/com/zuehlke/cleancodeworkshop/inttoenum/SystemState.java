package com.zuehlke.cleancodeworkshop.inttoenum;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Diese Klasse hält nur einen int als symbolischen System-Zustand.
 *
 * Übung: refaktorisiere int to ENUM in kleinen Schritte und mit so viel wie möglich automatsichen Refaktorings, sodass
 * die Tests immer grün bleiben.
 */
public class SystemState {

	public static final Map<Integer, String> errorCodeToDescriptionMap = new HashMap<Integer, String>() {
		{
			put(0, "All Services OK");
			put(1, "Communication OK");
			put(2, "Communication Disturbed");
			put(3, "MailService Failure");
			put(4, "ReportService Failure");
			put(5, "Database Connection Failure");
			put(6, "Internal Processing Failure");
		}
	};

	private final int state;

	SystemState(final int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

	// Alternative Look-Up-Map
	// public static final Map<Integer, String> errorCodeToDescriptionMap = new
	// HashMap<Integer, String>();
	// static {
	// errorCodeToDescriptionMap.put(ALL_SERVICES_OK, "All Services OK");
	// // ...
	// }

	public static String getDescriptionForState(final int state) {
		Optional<String> description = errorCodeToDescriptionMap.entrySet().stream()
				.filter(entry -> state == entry.getKey())
				.map(Map.Entry::getValue)
				.findFirst();

		if(description.isPresent()) {
			return description.get();
		} else {
			return "Unknown state";
		}
	}
}
