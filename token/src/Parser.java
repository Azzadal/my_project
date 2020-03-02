public class Parser {
    private String input;
    private int i;
    private float number;
    private char oper;

    public Parser(String input) {
        this.input = input;
    }

    public Token nextToken() throws Exception {
        if (i >= input.length())
            return null;

        while (input.charAt(i) == ' ') ++i;

        char c = input.charAt(i);
        ++i;

        if (c == '+') {
            oper = c;
            return Token.PLUS;
        }
        if (c == '-') {
            oper = c;
            return Token.MINUS;
        }
        if (c == '*') {
            oper = c;
            return Token.MULTIPLY;
        }
        if (c == '/') {
            oper = c;
            return Token.DIVIDE;
        }

        if (c >= '0' && c <= '9') {
            number = c - '0';
            readNumber();
            return Token.NUMBER;
        }

        throw new Exception("Unknown token");
    }

    float getNumber() {
        return number;
    }

    char getOper() {
        return oper;
    }

    private void readNumber() {
        // TODO handle float numbers
        while (i < input.length() && ((input.charAt(i) >= '0' && input.charAt(i) <= '9'))) {
            number = number * 10 + input.charAt(i) - '0';
            ++i;
        }
    }
}