package org.amicofragile.anobii4j;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;

public class AnobiiRestApiTest {
	private static final int LIMIT = 10;
	private static final String USERNAME = "amicofragile";
	private static final String API_KEY = "bbc152906134de3f21324c3b3aef4684";
	private static final String API_SIGNATURE = "6a6567d33e2f28d45d4f003df339ce66";
	@Test
	public void callGetSimpleShelfMethod() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user", USERNAME);
		params.put("limit", 10);
		params.put("start", 0);
		params.put("key", API_KEY);
		params.put("signature", API_SIGNATURE);
		RestTemplate rest = new RestTemplate();
		List<HttpMessageConverter<?>> converters = new LinkedList<HttpMessageConverter<?>>();
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setClassesToBeBound(ShelfResponse.class, ShelfItem.class);
		MarshallingHttpMessageConverter marshallingConverter = new MarshallingHttpMessageConverter(jaxb2Marshaller, jaxb2Marshaller);
		marshallingConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_XML, MediaType.TEXT_XML));
		converters.add(marshallingConverter);
		rest.setMessageConverters(converters);
		ShelfResponse shelf = rest.getForObject("http://api.anobii.com/shelf/getSimpleShelf?user_id={user}&limit={limit}&start={start}&api_key={key}&api_sig={signature}", ShelfResponse.class, params);
		assertNotNull(shelf);
		assertEquals(USERNAME, shelf.getUsername());
		assertEquals("all", shelf.getType());
		for(ShelfItem item : shelf.getItems()) {
			System.out.println(item);
		}
		assertEquals(LIMIT, shelf.getItems().size());
	}
}
