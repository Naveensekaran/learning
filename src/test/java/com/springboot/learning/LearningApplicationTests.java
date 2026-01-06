package com.springboot.learning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LearningApplicationTests {

	@Test
	void shouldPass() {
		assertEquals(5, 2 + 3);
	}

}
