package com.springboot.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class BeforeEach1Test {
    private static Map<String, String> map;

    @BeforeEach
    public void init() {
        System.out.println("Pre-processing before each test case");
        map = new HashMap<>();
        map.put("BTC" , "Bitcoin");
        map.put("ETH", "Ethereum");
        map.put("ADA", "Cardano");
        map.put("POT", "Polkadot");
    }

    @DisplayName("@BeforeEach Test1")
    @Test
    public void beforeEachTest() {
        map.put( "XRP", "Ripple");
        // Null 임.
        Assertions.assertDoesNotThrow(() -> map.get("XRP").toUpperCase());

    }

    @DisplayName("@BeforeEach Test2")
    @Test
    public void beforeEachTest2() {
        Assertions.assertDoesNotThrow(() -> map.get("XRP").toUpperCase());
    }
}
