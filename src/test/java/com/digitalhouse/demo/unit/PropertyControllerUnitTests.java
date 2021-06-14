package com.digitalhouse.demo.unit;

import com.digitalhouse.dtos.DistrictDTO;
import com.digitalhouse.entities.Property;
import com.digitalhouse.entities.Room;
import com.digitalhouse.repositories.impl.DistrictRepositoryImpl;
import com.digitalhouse.services.impl.PropertyServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PropertyControllerUnitTests {

	static Property property;

	@InjectMocks
	PropertyServiceImpl service;

	@InjectMocks
	DistrictRepositoryImpl repository;

	@BeforeAll
	public static void setUp() {
		List<Room> rooms = new ArrayList<>();

		rooms.add(new Room("Sala", 20.0, 23.0));
		rooms.add(new Room("Quarto", 15.0, 12.0));
		rooms.add(new Room("Banheiro", 8.0, 12.0));
		rooms.add(new Room("Cozinha", 25.0, 10.0));

		property = new Property();
		property.setProp_name("Casa da Stephanie");
		property.setProp_district("Centro");
		property.setRooms(rooms);
	}

	@Test
	void TotalSquareMetersPerProperty_NumberCorrect_Calculate() {
		assertEquals(986.0, service.getSquareMetersOfTheHouse(property));
	}

	@Test
	void HousePrice_DistrictCorrect_Get() {
		DistrictDTO expected = new DistrictDTO("Centro", 149.90);
		DistrictDTO actual = repository.findByName("Centro");
		assertEquals(expected.getName(), actual.getName());
	}

	@Test
	void HousePrice_DistrictIncorrect_Exception() {
		assertThrows(NoSuchElementException.class,
				() -> repository.findByName("Caminho das Arvores"));
	}

	@Test
	void BiggestRoomInTheHouse_ObjectCorrect_Get() {
		Room room = service.getBiggestRoomInTheHouse(property);
		assertEquals("Sala", room.getRoom_name());
	}

	@Test
	void SquareMetersPerRoom_ObjectCorrect_Calculate() {
		HashMap<Room, Double> squareMetersPerRoom = new HashMap<>();
		Room room = new Room("Sala de estar", 12.0, 12.0);

		squareMetersPerRoom = service.getSquareMetersPerRoom(property);
		squareMetersPerRoom.put(room, room.getRoom_width() * room.getRoom_length());

		assertEquals(144.0, squareMetersPerRoom.get(room));

	}
}

