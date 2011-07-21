package com.sales.house.vo;

import java.util.Collection;

public class House {

	private Collection<Room> rooms;
	private Collection<Room> bathrooms;

	public House(final Collection<Room> roomList, final Collection<Room> bathrooms) {
		this.rooms = roomList;
		this.bathrooms = bathrooms;
	}

	public Collection<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Collection<Room> rooms) {
		this.rooms = rooms;
	}

	public Collection<Room> getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(Collection<Room> bathrooms) {
		this.bathrooms = bathrooms;
	}

}
