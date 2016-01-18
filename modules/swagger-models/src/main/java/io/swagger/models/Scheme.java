package io.swagger.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Scheme {
    http("http"),
    https("https"),
    ws("ws"),
    wss("wss");

    private final String value;

    private Scheme(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Scheme forValue(String value) {
        for (Scheme item : Scheme.values()) {
            if (item.toValue().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    public String toValue() {
        return value;
    }
}