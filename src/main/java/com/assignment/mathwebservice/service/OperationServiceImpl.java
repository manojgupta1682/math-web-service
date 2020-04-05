package com.assignment.mathwebservice.service;

import org.springframework.stereotype.Service;

import com.assignment.mathwebservice.util.OperationType;
import com.assignment.mathwebservice.vo.OperandVO;

@Service
public class OperationServiceImpl implements OperationService{


	@Override
	public double calculate(OperandVO operandVO, OperationType operationType) {
		switch(operationType) {
		case ADD : return operandVO.getX() + operandVO.getY();
		case SUB : return operandVO.getX() - operandVO.getY();
		}

		return 0;
	}

}
