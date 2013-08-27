package ch.xonix.mensa.unibe.model;

public class ServiceUri {
	public static final String GET_MENSAS = "http://mensa.xonix.ch/v1/mensas";
	public static final String GET_CURRENT_MENUPLAN = "http://mensa.xonix.ch/v1/mensas/:id/dailyplan";
	public static final String GET_MENUPLAN = "http://mensa.xonix.ch/mensa/:id/plan/:date";
}
