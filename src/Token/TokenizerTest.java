package Token;

import Parser.SyntaxError;

public class TokenizerTest {

    public static void main(String[] args) {
        testHasNextToken();
        testPeek();
        testPeekWithParameter();
        testConsume();
        testConsumeWithParameter();
    }

    public static void testHasNextToken() {
        Tokenizer tokenizer = new Tokenizer("123");
        System.out.println(tokenizer.hasNextToken()); // Expected: true

        Tokenizer emptyTokenizer = new Tokenizer("");
        System.out.println(emptyTokenizer.hasNextToken()); // Expected: false
    }

    public static void testPeek() {
        Tokenizer tokenizer = new Tokenizer("123");
        System.out.println(tokenizer.peek()); // Expected: 123
    }

    public static void testPeekWithParameter() {
        Tokenizer tokenizer = new Tokenizer("abc def");
        System.out.println(tokenizer.peek("abc")); // Expected: true
        System.out.println(tokenizer.peek("def")); // Expected: false
    }

    public static void testConsume() {
        Tokenizer tokenizer = new Tokenizer("123");
        System.out.println(tokenizer.consume()); // Expected: 123
        System.out.println(tokenizer.hasNextToken()); // Expected: false
    }

    public static void testConsumeWithParameter() {
        Tokenizer tokenizer = new Tokenizer("abc");
        try {
            tokenizer.consume("abc");
            System.out.println("Test Passed"); // Expected: Test Passed
        } catch (SyntaxError e) {
            System.out.println("Test Failed: " + e.getMessage());
        }

        Tokenizer tokenizer2 = new Tokenizer("def");
        try {
            tokenizer2.consume("abc");
            System.out.println("Test Failed: Expected SyntaxError to be thrown");
        } catch (SyntaxError e) {
            System.out.println("Test Passed: Expected SyntaxError to be thrown");
        }
    }
}
