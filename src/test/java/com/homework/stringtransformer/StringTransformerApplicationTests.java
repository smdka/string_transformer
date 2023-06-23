package com.homework.stringtransformer;

import com.homework.stringtransformer.controller.StringTransformerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class StringTransformerApplicationTests {
	@Autowired
	StringTransformerController controller;

	@Test
	void contextLoads() {
		assertNotNull(controller);
	}

}
