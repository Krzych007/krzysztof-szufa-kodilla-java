package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Test
    void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double addResult = calculator.add(1.0, 2.0);
        double subResult = calculator.sub(4.0, 3.0);
        double mulResult = calculator.mul(5.0, 6.0);
        double divResult = calculator.div(8.0, 4.0);

        //Then
        assertEquals(3.0, addResult, 0.001);
        assertEquals(1.0, subResult, 0.001);
        assertEquals(30.0, mulResult, 0.001);
        assertEquals(2.0, divResult, 0.001);
    }
}
