package com.digitalhouse.demo;

import com.digitalhouse.demo.DTOs.PropertsDTO;
import com.digitalhouse.demo.DTOs.RoomDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@BeforeAll
	static void initProperts(){
		List<RoomDTO> rooms = new ArrayList<>();
		RoomDTO r1 = new RoomDTO("Banheiro",4.0,2.0);
		RoomDTO r2 = new RoomDTO("Cozinha",6.0,4.0);
		RoomDTO r3 = new RoomDTO("Quarto",8.0,5.0);
		rooms.add(r1);
		rooms.add(r2);
		rooms.add(r3);
		PropertsDTO p1 = new PropertsDTO("Casa Guilherme","Campinas", rooms);
	}

	@Test
	void contextLoads() {
	}

}
