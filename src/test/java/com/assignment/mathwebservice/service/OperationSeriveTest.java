package com.assignment.mathwebservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.mathwebservice.util.OperationType;
import com.assignment.mathwebservice.vo.OperandVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationSeriveTest {

	@Autowired
	private OperationService operationService;
	
	@Test
	public void additionTest() {
		OperandVO operand = new OperandVO();
		operand.setX(100);
		operand.setY(50);
		assertEquals(150D, operationService.calculate(operand, OperationType.ADD));
	}

	@Test
	public void substractionTest() {
		OperandVO operand = new OperandVO();
		operand.setX(100);
		operand.setY(50);
		assertEquals(50D, operationService.calculate(operand, OperationType.SUB));
	}
}
