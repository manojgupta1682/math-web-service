package com.assignment.mathwebservice.service;

import com.assignment.mathwebservice.util.OperationType;
import com.assignment.mathwebservice.vo.OperandVO;

public interface OperationService {
	
	public double calculate(OperandVO operandVO,OperationType operationType);

}
