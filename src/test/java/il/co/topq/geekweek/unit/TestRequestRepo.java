package il.co.topq.geekweek.unit;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import il.co.topq.geekweek.infra.RequestBodyRepository;

public class TestRequestRepo {

	private RequestBodyRepository repo;

	@Before
	public void setup() {
		repo = new RequestBodyRepository();
	}

	@Test
	public void testSetFirstKeyInRequest() throws IOException {
		String requestString = repo.get("pet").setFirst("name", "Piky").setAll("id", "3").asString();
		Assert.assertTrue(requestString.contains("Piky"));
	}

	@Test
	public void testSetAllKeysInRequest() throws IOException {
		String requestString = repo.get("pet").setFirst("name", "Piky").setAll("id", "3").asString();
		Assert.assertTrue(requestString.indexOf('3') == 12);
		Assert.assertTrue(requestString.lastIndexOf('3') == 168);
	}

	@Test(expected = IllegalStateException.class)
	public void testRequestIsNotReadyException() throws IOException {
		repo.get("pet").setAll("id", "3").asString();
	}

}
