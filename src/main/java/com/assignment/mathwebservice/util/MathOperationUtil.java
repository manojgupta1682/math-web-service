package com.assignment.mathwebservice.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Provide utility function required by math web service
  */
public class MathOperationUtil {
	private static final DecimalFormat df = new DecimalFormat("###.00");

	/**
	 * if decimal value of passed value is greater than zero then it will return string of double value
	 * if decimal value of passed value is Zero then it will return string of integer value
	 * @param val
	 * @return
	 */
	public static String convertValueToResponseRequiredString(double val) { 
		BigDecimal bigVal = new BigDecimal(val);
		double decimalPart = bigVal.subtract(new BigDecimal(bigVal.intValue())).doubleValue();
		return decimalPart > 0 ? String.valueOf(df.format(bigVal.doubleValue())) : String.valueOf(bigVal.intValue());
	}

}
