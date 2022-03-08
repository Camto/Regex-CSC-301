package regex.test;

// import static org.junit.Assert.assertArrayEquals;
// import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.List;

import regex.*;

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
	
	@Test
	public void matchBasicConcatTest() {
		FSA matchBasicConcat = new Concatenation(List.of(new Literal("a"), new Literal("b"))).getCompiled();
		
		assertTrue(matchBasicConcat.doesMatch("ab"));
		assertFalse(matchBasicConcat.doesMatch("ba"));
	}
	
	@Test
	public void matchConcatWithAlternTest() {
		FSA matchConcatWithAltern = new Concatenation(List.of(
			new Alternation(List.of(new Literal("a"), new Literal("b"))),
			new Alternation(List.of(new Literal("c"), new Literal("d")))
		)).getCompiled();

		assertTrue(matchConcatWithAltern.doesMatch("ac"));
		assertTrue(matchConcatWithAltern.doesMatch("ad"));
		assertTrue(matchConcatWithAltern.doesMatch("bc"));
		assertTrue(matchConcatWithAltern.doesMatch("bd"));
		
		assertFalse(matchConcatWithAltern.doesMatch("ca"));
	}
}
