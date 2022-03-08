package regex.test;

// import static org.junit.Assert.assertArrayEquals;
// import static org.junit.Assert.assertEquals;
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
	
	@Test
	public void matchInMiddleTest() {
		Regex matchInMiddle = new Regex("hello");
		assertTrue(matchInMiddle.doesMatch("abcde hello abcde"));
		assertFalse(matchInMiddle.doesMatch("abcde abcde"));
	}
	
	@Test
	public void matchAOrBTest() {
		Regex matchAOrB = new Regex("a|b");

		assertTrue(matchAOrB.doesMatch("a"));
		assertTrue(matchAOrB.doesMatch("b"));
		assertFalse(matchAOrB.doesMatch("c"));
		assertFalse(matchAOrB.doesMatch("d"));
	}
}
