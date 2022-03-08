package regex.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import regex.Regex;

public class RegexTest {
	@Test
	public void matchSingleATest() {
		Regex matchSingleA = new Regex("a");
		assertTrue(matchSingleA.doesMatch("a"));
		assertFalse(matchSingleA.doesMatch("b"));
	}
}
