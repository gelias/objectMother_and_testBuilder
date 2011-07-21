package com.sales.house.validator;

import com.sales.house.vo.House;

public class ValidatorHouseSales {

	private int numberOfRooms;
	private int numberOfBathrooms;

	public ValidatorHouseSales(int numberOfRooms, int numberOfBathrooms) {
		this.numberOfRooms = numberOfRooms;
		this.numberOfBathrooms = numberOfBathrooms;
	}

	public Boolean checkRoomsRule(final House homeToBePurchased) {
		return homeToBePurchased.getRooms().size() == this.numberOfRooms;
	}

	public Boolean checkBathRoomRules(House homeToBePurchased) {
		return homeToBePurchased.getBathrooms().size() == this.numberOfBathrooms;

	}

	public Boolean checkHouseRules(House homeToBePurchased) {
		return checkBathRoomRules(homeToBePurchased) && checkRoomsRule(homeToBePurchased);
	}
}
