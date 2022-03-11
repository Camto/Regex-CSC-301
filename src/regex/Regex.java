package regex;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import regex.ast.*;
import regex.fsa.FSA;

public class Regex {
	private AST ast;
	private FSA fsa;
	
	private static class ASTAndRest {
		public AST ast;
		public String rest;
		
		public ASTAndRest(AST ast, String rest) {
			this.ast = ast;
			this.rest = rest;
		}
	}
	
	public Regex(String expr) {
		ast = parse(expr).ast;
		fsa = ast.compile();
	}
	
	private static ASTAndRest parse(String expr) {
		ArrayList<ArrayList<AST>> fullExpr = new ArrayList<>();
		ArrayList<AST> currentAlt = new ArrayList<>();
		
		for(; !expr.equals(""); expr = expr.substring(1)) {
			char first_char = expr.charAt(0);
			if(first_char == '(') {
				ASTAndRest group = parse(expr.substring(1));
				expr = group.rest;
				currentAlt.add(group.ast);
			} else if(first_char == ')') {
				expr = expr.substring(1);
				break;
			} else if(first_char == '|') {
				fullExpr.add(currentAlt);
				currentAlt = new ArrayList<>();
			} else if(first_char == '*') {
				currentAlt.add(new KleeneStar(currentAlt.remove(currentAlt.size() - 1)));
			} else if(first_char == '+') {
				currentAlt.add(new KleenePlus(currentAlt.remove(currentAlt.size() - 1)));
			} else if(first_char == '*') {
				currentAlt.add(new Optional(currentAlt.remove(currentAlt.size() - 1)));
			} else {
				currentAlt.add(new Literal(expr.substring(0, 1)));
			}
		}
		
		fullExpr.add(currentAlt);
		return new ASTAndRest(collapseAltsAndConcats(fullExpr), expr);
	}
	
	private static AST collapseAltsAndConcats(ArrayList<ArrayList<AST>> altsAndConcats) {
		return new Alternation(
			altsAndConcats.stream()
				.map(alt -> new Concatenation(alt))
				.collect(Collectors.toList())
		);
	}
	
	public boolean doesMatch(String str) {
		return fsa.doesMatch(str);
	}
	
	public boolean doesMatchExactly(String str) {
		return fsa.doesMatchExactly(str);
	}
}
