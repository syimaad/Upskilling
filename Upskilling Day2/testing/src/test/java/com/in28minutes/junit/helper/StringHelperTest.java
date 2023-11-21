package com.in28minutes.junit.helper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringHelperTest {
	
	StringHelper helper = new StringHelper();
	
	@Test
	void testTruncate() {
		
		String actual = helper.truncateAInFirst2Positions("AAIMAAD");
		String expected = "IMAAD";
		assertEquals(actual, expected);
	}
	 
	@Test
	void testTrueOrFalse() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("AIMAADAB"));
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("EYEYEY"));
	}
	
}
