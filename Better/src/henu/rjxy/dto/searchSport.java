package henu.rjxy.dto;

public class searchSport {
	private String username;
	private int sport_value;
	private String image;
	public String getUsername() {
		return username;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getSport_value() {
		return sport_value;
	}
	public void setSport_value(int sport_value) {
		this.sport_value = sport_value;
	}
}
