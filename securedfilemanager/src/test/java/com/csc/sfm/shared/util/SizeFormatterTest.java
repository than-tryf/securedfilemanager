package com.csc.sfm.shared.util;

import junit.framework.Assert;

import org.junit.Test;

import com.csc.sfm.server.infra.util.SizeFormatter;

public class SizeFormatterTest {

	@Test
	public void testFormat_zero() {
		assertFormatMethod(0, "0 Ko");
	}
	
	@Test
	public void testFormat_lessThan1Ko() {
		assertFormatMethod(103, "0,1 Ko");
	}
	
	@Test
	public void testFormat_lessThan1Mo() {
		assertFormatMethod(13600, "13,28 Ko");
	}
	
	@Test
	public void testFormat_lessThan1Go() {
		assertFormatMethod(2708576, "2,58 Mo");
	}
	
	@Test
	public void testFormat_MoreThan100Mo() {
		assertFormatMethod(209715200, "200 Mo");
	}
	
	/*
	 * PRIVATE
	 */

	private void assertFormatMethod(double size, String expected) {
		// Given
		double underTest = size;
		
		// When
		String actual = SizeFormatter.format(underTest);
		
		// Then
		Assert.assertEquals(expected, actual);
	}
	
}
