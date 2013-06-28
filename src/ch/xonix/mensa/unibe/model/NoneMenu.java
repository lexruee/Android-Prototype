package ch.xonix.mensa.unibe.model;

import org.json.JSONObject;

public class NoneMenu extends Menu{

	public NoneMenu(JSONObject menuJsonObject) {
		super(menuJsonObject);

	}

	public NoneMenu() {
		super(null);
	}

	public String getTitle() {

		return "Statusinformation";
	}

	public String getContent() {
		return "Zurzeit sind keine aktuellen\n Menü-Informationen abrufbar.";
	}
}
