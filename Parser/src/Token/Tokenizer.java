package Token;

import Parser.SyntaxError;

import java.util.NoSuchElementException;

public class Tokenizer{
    private String src, next;  private int pos;
    public Tokenizer(String src){
        this.src = src;  pos = 0;
        computeNext();
    }
    public boolean hasNextToken() {
        return next != null;
    }
    public void checkNextToken(){
        if (!hasNextToken()) throw new NoSuchElementException("no more tokens");
    }
    public String peek() {
        checkNextToken();
        return next;
    }
    public boolean peek(String s) {
        if (!hasNextToken()) return false;
        return peek().equals(s);
    }

    public String consume() {
        checkNextToken();
        String result = next;
        computeNext();
        return result;
    }
    public void consume(String s)
            throws SyntaxError {
        if (peek(s))
            consume();
        else
            throw new SyntaxError(s + " expected, got :"+peek());
    }

    public void computeNext(){
        StringBuilder s = new StringBuilder();
        while (pos < src.length() && Character.isSpace(src.charAt(pos))) pos++; // delete space

        if (pos == src.length()) { next = null;  return; }
        char c = src.charAt(pos);
        if (Character.isDigit(c)) {
            s.append(c);
            for (pos++; pos < src.length() &&
                    Character.isDigit(src.charAt(pos)); pos++)
                s.append(src.charAt(pos));
        }else if (Character.isLetter(c)) {
            s.append(c);
            for (pos++; pos < src.length() &&
                    Character.isAlphabetic(src.charAt(pos)); pos++)
                s.append(src.charAt(pos));
        }else if (c == '+'
                || c == '('
                || c == '-'
                || c == '*'
                || c == '/'
                || c == '%'
                || c == ')'
                || c == '='
//                || c == '#'
                || c == '{'
                || c == '}'
                || c == '^'
                || c == ';'
                || c==',') {
            s.append(c);  pos++;
        }else if (c == '#') {
            while (pos < src.length() && !Character.isWhitespace(src.charAt(pos))) {
                pos++;
            }
        }else throw new NoSuchElementException("unknown character: " + c);
        next = s.toString();
    }
}

