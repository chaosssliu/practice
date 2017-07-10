package com.struts.test.service;

public class TutorialFinderService {

	public String getBestTutorialSite(String language) {
		if (language.equals("java")) {
			return "google java";
		} else {
			return "language not supported yet";
		}
	}
}
