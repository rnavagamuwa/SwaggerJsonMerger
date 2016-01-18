package io.swagger.models;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class SchemeTest {

    @Test
    public void testForValue() {
        assertEquals(Scheme.forValue("http"), Scheme.http, "The forValue must return HTTP for http");
        assertNull(Scheme.forValue("unknown"), "The forValue must return null for unknown values");
    }

    @Test
    public void testToValue() {
        assertEquals(Scheme.http.toValue(), "http", "The toValue must return http for HTTP");
    }

    @Test
    public void testValueOf() {
        assertEquals(Scheme.valueOf("HTTP"), Scheme.http, "The valueOf must return HTTP for http");
    }
}
