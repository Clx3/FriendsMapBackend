package fi.tuni.friendsmap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class Location {
	
	@Id
	@GeneratedValue
	public long id;
	
	@Column(name="userId")
	private long userId;
	
	@Column(name="longitude")
	private double longitude;
	
	@Column(name="latitude")
	private double latitude;
	
	public Location() {}
	
	public Location(long userId, double longitude, double latitude) {
		this.userId = userId;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

}
