package com.assignment.mathwebservice.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MathOperationUtilTest {

	@Test
	public void return_IntValueString_IfDecimalValueIsZero_OfPassedValue() {

		assertEquals("100",MathOperationUtil.convertValueToResponseRequiredString(100.00));

	}

	@Test
	public void return_DoubleValueString_IfDecimalValueIs_GreaterThanZero_OfPassedValue() {

		assertEquals("100.50",MathOperationUtil.convertValueToResponseRequiredString(100.50));

	}

}
