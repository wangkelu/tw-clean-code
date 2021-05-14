package com.zuehlke.cleancodeworkshop.person;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String familyName;
	private String givenName;
	private String nationality;
	private boolean capitalizeSurname;
	private boolean olympicMode;

	private static List<String> surnameFirst = new ArrayList<String>();
	static {
		surnameFirst.add("CHN");
		surnameFirst.add("KOR");
		// etc...
	}

	public Person(String familyName, String givenName, String nationality) {
		this(familyName, givenName, nationality, false, false);
	}

	public Person(String familyName, String givenName, String nationality,
			boolean olympicMode, boolean capitalizeSurname) {
		this.familyName = familyName;
		this.givenName = givenName;
		this.nationality = nationality;
		this.capitalizeSurname = capitalizeSurname;
		this.olympicMode = olympicMode;
	}

	@Override
	public String toString() {
		return nameString();
	}

	private String nameString() {
		StringBuilder name = new StringBuilder();
		if (capitalizeSurname) {
			name.append(familyName.toUpperCase());
		} else {
			name.append(familyName);
		}
		
		if (surnameFirst()) {
			return name.append(" ").append(givenName).toString();
		} else {
			return name.insert(0, givenName).insert(givenName.length(), " ").toString();
		}
	}

	private boolean surnameFirst() {
		if (!olympicMode)
			return false;
		return surnameFirst.contains(nationality);
	}

}
