package org.amicofragile.anobii4j;

import org.junit.Test;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

public class AnobiiApiTest {
	private static final String API_KEY = "a-key";
	private static final String API_SIGNATURE = "a-signature";

	@Test
	public void usesProvidedCredentialsForRestCalls() throws Exception {
		final AnobiiApi anobii = new AnobiiApi(API_KEY, API_SIGNATURE);
		
	}
}
