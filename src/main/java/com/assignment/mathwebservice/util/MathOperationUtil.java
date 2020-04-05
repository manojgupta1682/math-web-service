package com.assignment.mathwebservice.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MathOperationUtil {
	private static final DecimalFormat df = new DecimalFormat("###.00");

	
	public static String convertValueToResponseRequiredString(double val) { 
		BigDecimal bigVal = new BigDecimal(val);
		double decimalPart = bigVal.subtract(new BigDecimal(bigVal.intValue())).doubleValue();
		return decimalPart > 0 ? String.valueOf(df.format(bigVal.doubleValue())) : String.valueOf(bigVal.intValue());
	}

}
