package regex.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import regex.Regex;

public class RegexTest {
	@Test
	public void maatchTest() {
		assertEquals(Regex.maaatch(), "hello");
	}
}
