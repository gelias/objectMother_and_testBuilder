package com.sales.house.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sales.house.object.mother.HouseBuilder;
import com.sales.house.validator.ValidatorHouseSales;
import com.sales.house.vo.House;

public class ValidatingANewHousePurchase {

	private static final int TWO_BATHROOMS = 2;
	private static final int THREE_ROOMS = 3;
	private static final int ONE_BATHROOM = 1;
	private static final int ONE_ROOM = 1;
	private ValidatorHouseSales salesValidator;

	@Before
	public void setUp() throws Exception {
		salesValidator = new ValidatorHouseSales(ONE_ROOM, ONE_BATHROOM);
	}

	@Test
	public void shouldValidateDesiredNumberOfRooms() {

		final House newHouse = HouseBuilder.get().withOneRoom().build();
		final Boolean isExpectedNumberOfRooms = salesValidator.checkRoomsRule(newHouse);
		assertTrue("should validate house based on the number of rooms", isExpectedNumberOfRooms);
	}

	@Test
	public void shouldInvalidatePurchaseHouseDueNotDesiredNumberOfRooms() {

		final House newhouse = HouseBuilder.get().withThreeRooms().build();
		final Boolean isUnexpectedNumberOfRooms = salesValidator.checkRoomsRule(newhouse);
		assertFalse("should validate house based on the number of rooms", isUnexpectedNumberOfRooms);
	}

	@Test
	public void shouldInvalidatePurchaseHouseDueNotDesiredNumberOfBathrooms() {

		final House newhouse = HouseBuilder.get().withOneBathroom().build();
		final Boolean isExpectedNumberOfBathrooms = salesValidator.checkBathRoomRules(newhouse);
		assertTrue("should validate house based on the number of bathrooms", isExpectedNumberOfBathrooms);
	}

	@Test
	public void shouldValidateDesiredNumberOfBathrooms() {

		final House newhouse = HouseBuilder.get().withTwoBathrooms().build();
		final Boolean isUnexpectedNumberOfBathrooms = salesValidator.checkBathRoomRules(newhouse);
		assertFalse("should validate house based on the number of bathrooms", isUnexpectedNumberOfBathrooms);
	}

	@Test
	public void shouldValidatePurchaseHouseAsDesired() {
		salesValidator = new ValidatorHouseSales(THREE_ROOMS, TWO_BATHROOMS);
		final House awesomeHouse = HouseBuilder.get().withThreeRooms().withTwoBathrooms().build();
		final Boolean isPerfectHouse = salesValidator.checkHouseRules(awesomeHouse);
		assertTrue("should be the sweet house", isPerfectHouse);
	}

	@Test
	public void shouldInvalidatePurchaseHouseDueWrongNumberOfRooms() {
		salesValidator = new ValidatorHouseSales(THREE_ROOMS, TWO_BATHROOMS);
		final House awesomeHouse = HouseBuilder.get().withOneRoom().withTwoBathrooms().build();
		final Boolean isNotDesiredHouse = salesValidator.checkHouseRules(awesomeHouse);
		assertFalse("should be the sweet house", isNotDesiredHouse);
	}

	@Test
	public void shouldInvalidatePurchaseHouseDueWrongNumberOfBathrooms() {
		salesValidator = new ValidatorHouseSales(THREE_ROOMS, TWO_BATHROOMS);
		final House awesomeHouse = HouseBuilder.get().withThreeRooms().withOneBathroom().build();
		final Boolean isNotDesiredHouse = salesValidator.checkHouseRules(awesomeHouse);
		assertFalse("should be the sweet house", isNotDesiredHouse);
	}

}
