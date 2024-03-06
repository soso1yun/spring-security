package com.example.springsecurity;

import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.Random;

class SecretKeyGeneratorTests {

	@Test
	void secreteKeyRandomGenerator() {

		byte[] randomBytes = new byte[32];
		new Random().nextBytes(randomBytes);

		String secretKey = Base64.getEncoder().encodeToString(randomBytes);

		System.out.println(secretKey);

	}

}
