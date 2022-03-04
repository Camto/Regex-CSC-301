package regex;

public class Regex {
	
//	private String input;

	public Regex(String input)
	{

	}
	
	private void parseCharacters()
	{
//		x	The character x
//		\\	The backslash character
//		\0n	The character with octal value 0n (0 <= n <= 7)
//		\0nn	The character with octal value 0nn (0 <= n <= 7)
//		\0mnn	The character with octal value 0mnn (0 <= m <= 3, 0 <= n <= 7)
//		\xhh	The character with hexadecimal value 0xhh
//		\uhhhh	The character with hexadecimal value 0xhhhh
//		\x{h...h}	The character with hexadecimal value 0xh...h (Character.MIN_CODE_POINT  <= 0xh...h <=  Character.MAX_CODE_POINT)
//		\t	The tab character ('\u0009')
//		\n	The newline (line feed) character ('\u000A')
//		\r	The carriage-return character ('\u000D')
//		\f	The form-feed character ('\u000C')
//		\a	The alert (bell) character ('\u0007')
//		\e	The escape character ('\u001B')
//		\cx	The control character corresponding to x
	}
	
	private void parseCharacterClasses()
	{
//		[abc]	a, b, or c (simple class)
//		[^abc]	Any character except a, b, or c (negation)
//		[a-zA-Z]	a through z or A through Z, inclusive (range)
//		[a-d[m-p]]	a through d, or m through p: [a-dm-p] (union)
//		[a-z&&[def]]	d, e, or f (intersection)
//		[a-z&&[^bc]]	a through z, except for b and c: [ad-z] (subtraction)
//		[a-z&&[^m-p]]	a through z, and not m through p: [a-lq-z](subtraction)
	}
	
	private void parsePredefinedCharacterClasses()
	{
//		.	Any character (may or may not match line terminators)
//		\d	A digit: [0-9]
//		\D	A non-digit: [^0-9]
//		\s	A whitespace character: [ \t\n\x0B\f\r]
//		\S	A non-whitespace character: [^\s]
//		\w	A word character: [a-zA-Z_0-9]
//		\W	A non-word character: [^\w]
	}
	
	private void parseBoundaryMatchers()
	{
//		^	The beginning of a line
//		$	The end of a line
	}
	
	private void parseGreedyQuantifiers()
	{
//		X?	X, once or not at all
//			X*	X, zero or more times
//			X+	X, one or more times
//			X{n}	X, exactly n times
//			X{n,}	X, at least n times
//			X{n,m}	X, at least n but not more than m times
	}
	
	private void parseReluctantQuantifiers()
	{
//		X??	X, once or not at all
//		X*?	X, zero or more times
//		X+?	X, one or more times
//		X{n}?	X, exactly n times
//		X{n,}?	X, at least n times
//		X{n,m}?	X, at least n but not more than m times
	}
	
	private void parsePossessiveQuantifiers()
	{
//		X?+	X, once or not at all
//		X*+	X, zero or more times
//		X++	X, one or more times
//		X{n}+	X, exactly n times
//		X{n,}+	X, at least n times
//		X{n,m}+	X, at least n but not more than m times
	}
	
	private void parseRangeQuantifier()
	{

	}
	
	private void parseLogicalOperators()
	{
//		XY	X followed by Y
//		X|Y	Either X or Y
//		(X)	X, as a capturing group	
	}
	
	private void parseQuotation()
	{
//		\	Nothing, but quotes the following character
//		\Q	Nothing, but quotes all characters until \E
//		\E	Nothing, but ends quoting started by \Q
	}
	
	public static String maaatch() {
		return "hello";
	}
}
