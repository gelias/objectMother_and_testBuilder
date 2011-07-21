package com.sales.house.object.mother;

import java.util.ArrayList;
import java.util.Collection;

import com.sales.house.vo.Bathroom;
import com.sales.house.vo.House;
import com.sales.house.vo.Room;

public class HouseBuilder {

	private Collection<Room> roomList = new ArrayList<Room>();
	private Collection<Room> bathrooms = new ArrayList<Room>();

	public static HouseBuilder get() {
		return new HouseBuilder();
	}

	public HouseBuilder withOneRoom() {
		this.roomList.add(new Room());
		return this;
	}

	public HouseBuilder withThreeRooms() {
		this.roomList.add(new Room());
		this.roomList.add(new Room());
		this.roomList.add(new Room());
		return this;
	}

	public HouseBuilder withTwoBathrooms() {
		bathrooms.add(new Bathroom());
		bathrooms.add(new Bathroom());
		return this;
	}

	public HouseBuilder withOneBathroom() {
		bathrooms.add(new Bathroom());
		return this;
	}

	public House build() {
		return new House(this.roomList, this.bathrooms);
	}

}
