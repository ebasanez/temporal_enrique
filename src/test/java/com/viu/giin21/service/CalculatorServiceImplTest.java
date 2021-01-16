package com.viu.giin21.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorServiceImplTest {

    private final CalculatorServiceImpl subject = new CalculatorServiceImpl();

    //@Test
    public void testCalculate() {
        Double result = subject.multiply(3d, 2d);
        Assertions.assertEquals(6d, result);
    }

}