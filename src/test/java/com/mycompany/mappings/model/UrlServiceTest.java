package com.mycompany.mappings.model;

import com.mycompany.mappings.model.util.UrlService;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author David <david.perez@hospitalitaliano.org.ar>
 */
public class UrlServiceTest {

    private UrlService service;

    @Before
    public void setUp() {
        service = new UrlService();
    }

    @Test
    public void testUrlToString() {
        String input = "http://documentos/dni";
        String expected = "DNI";

        String output = service.getStringByUrl(input);

        assertThat(output, is(expected));
    }

    @Test
    public void testStringToUrl() {
        String input = "DNI";
        String expected = "http://documentos/dni";

        String output = service.getUrlByString(input);

        assertThat(output, is(expected));
    }

}
