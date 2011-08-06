package com.csc.sfm.shared.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class SizeFormatter {

	/**
	 * 0       -> 0 Ko
	 * 103     -> 0.1 Ko
	 * 1300    -> 1.3 Mo
	 * 1108576 -> 1.1 Go
	 * 
	 */	
	public static String format(double value) {
		String result = "0 Ko";
		String unit = "";
		BigDecimal size = new BigDecimal(value);
		BigDecimal opeRes = new BigDecimal(0.0);
		DecimalFormat df = new DecimalFormat("###.##");

		if (value <= 0) {
			return "0 Ko";
		}
		
		if (value > 0) {
			if (value > 1024 * 1024 * 1024) { // size > 1 Go
				opeRes = size.divide(new BigDecimal(1024 * 1024 * 1024));
				unit = "Go";
			} else if (value > 1024 * 1024) { // size > 1 Mo
				opeRes = size.divide(new BigDecimal(1024 * 1024));
				unit = "Mo";
			} else {
				opeRes = size.divide(new BigDecimal(1024));
				unit = "Ko";
			}
			result = df.format(opeRes) + " " + unit;
		}
		
		return result;
	}
	
}
