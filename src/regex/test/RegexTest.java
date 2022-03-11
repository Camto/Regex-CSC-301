package regex.test;

// import static org.junit.Assert.assertArrayEquals;
// import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.List;

import regex.Regex;
import regex.ast.*;
import regex.fsa.FSA;

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
	public void matchExactlyTest() {
		Regex matchInMiddle = new Regex("hello");
		
		assertTrue(matchInMiddle.doesMatchExactly("hello"));
		assertFalse(matchInMiddle.doesMatchExactly("hello abcde"));
		assertFalse(matchInMiddle.doesMatchExactly("abcde hello"));
	}
	
	@Test
	public void matchAOrBTest() {
		Regex matchAOrB = new Regex("a|b");

		assertTrue(matchAOrB.doesMatch("a"));
		assertTrue(matchAOrB.doesMatch("b"));
		assertFalse(matchAOrB.doesMatch("c"));
		assertFalse(matchAOrB.doesMatch("d"));
	}
	
	@Test
	public void matchConcatWithAlternTest() {
		Regex matchConcatWithAltern = new Regex("(a|b)(c|d)");

		assertTrue(matchConcatWithAltern.doesMatchExactly("ac"));
		assertTrue(matchConcatWithAltern.doesMatchExactly("ad"));
		assertTrue(matchConcatWithAltern.doesMatchExactly("bc"));
		assertTrue(matchConcatWithAltern.doesMatchExactly("bd"));
		
		assertFalse(matchConcatWithAltern.doesMatch("ca"));
	}
	
	@Test
	public void matchManyATest() {
		Regex matchManyA = new Regex("ya*z");

		assertTrue(matchManyA.doesMatch("yaaaz"));
		assertTrue(matchManyA.doesMatch("yz"));

		assertFalse(matchManyA.doesMatch("y"));
		assertFalse(matchManyA.doesMatch("yaaaaa"));
	}
	
	@Test
	public void matchOneOrMoreATest() {
		Regex matchManyA = new Regex("ya+z");

		assertTrue(matchManyA.doesMatch("yaaaz"));
		
		assertFalse(matchManyA.doesMatch("yz"));
		assertFalse(matchManyA.doesMatch("y"));
		assertFalse(matchManyA.doesMatch("yaaaaa"));
	}
	
	@Test
	public void optionalATest() {
		Regex matchManyA = new Regex("ya?z");
		
		assertTrue(matchManyA.doesMatch("yaz"));
		assertTrue(matchManyA.doesMatch("yz"));

		assertFalse(matchManyA.doesMatch("yaaaz"));
		assertFalse(matchManyA.doesMatch("y"));
		assertFalse(matchManyA.doesMatch("yaaaaa"));
	}
}
