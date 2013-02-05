package org.springframework.samples.mvc.mapping;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.xml.XmlPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * MappingControllerICase.
 *
 * @author Rene Gielen
 */
public class MappingControllerICase {

	static final String APP_URL_UNDER_TEST = "http://localhost:8080/spring-mvc-showcase";

	@Test
	public void testWebClientAccessesNegotiatedXmlContentByDefault() throws Exception {
		final WebClient webClient = new WebClient();
		final XmlPage page = webClient.getPage(APP_URL_UNDER_TEST + "/mapping/produces/negotiate");
		assertNotNull(page);
		final String content = page.getContent();
		assertNotNull(content);
		System.out.println(content);
		assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><javaBean><foo>bar</foo><fruit>apple</fruit></javaBean>", content);
	}

	@Test
	public void testWebClientAccessesNegotiatedJsonContentByEnding() throws Exception {
		final WebClient webClient = new WebClient();
		final Page page = webClient.getPage(APP_URL_UNDER_TEST + "/mapping/produces/negotiate.json");
		checkJsonResult(page);
	}

	@Test
	public void testWebClientAccessesNegotiatedJsonContentByAcceptHeader() throws Exception {
		final WebClient webClient = new WebClient();
		webClient.addRequestHeader("Accept", "application/json");
		final Page page = webClient.getPage(APP_URL_UNDER_TEST + "/mapping/produces/negotiate");
		checkJsonResult(page);
	}

	private void checkJsonResult( Page page ) {
		assertNotNull(page);
		WebResponse response = page.getWebResponse();
		assertEquals("application/json", response.getContentType());
		String json = response.getContentAsString();
		assertEquals("{\"foo\":\"bar\",\"fruit\":\"apple\"}", json);
		System.out.println(json);
	}
}
