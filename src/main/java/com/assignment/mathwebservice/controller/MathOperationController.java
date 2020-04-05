package com.assignment.mathwebservice.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.mathwebservice.service.OperationService;
import com.assignment.mathwebservice.util.MathOperationUtil;
import com.assignment.mathwebservice.util.OperationType;
import com.assignment.mathwebservice.vo.OperandVO;

@RestController
@RequestMapping("/api")
public class MathOperationController {

	@Autowired
	private OperationService operationService;


	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public <T> ResponseEntity<T> addOperation(@RequestBody OperandVO  operandVO) throws Exception{
		double res = operationService.calculate(operandVO,OperationType.ADD);

		HashMap<String,String> map = new HashMap<>();
		map.put("result", MathOperationUtil.convertValueToResponseRequiredString(res));

		return (ResponseEntity<T>) new ResponseEntity<>(map,HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/diff", method = RequestMethod.POST)
	public <T> ResponseEntity<T> subtractOperation(@RequestBody OperandVO  operandVO) throws Exception{
		double res = operationService.calculate(operandVO,OperationType.SUB);

		HashMap<String,String> map = new HashMap<>();
		map.put("result", MathOperationUtil.convertValueToResponseRequiredString(res));

		return (ResponseEntity<T>) new ResponseEntity<>(map,HttpStatus.OK); 
	}
	
}
