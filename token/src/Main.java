import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Stack<Character> oper = new Stack<>();
        Stack<Float> num = new Stack<>();
        Parser parser = new Parser("2+23-26/2");
        while (true) {
            Token token = parser.nextToken();

            if (token == null)
                break;
            if (token == Token.NUMBER) {
                num.push(parser.getNumber());
            }
            if (token == Token.PLUS) {
                oper.push(parser.getOper());
            }
            if (token == Token.MINUS) {
                oper.push(parser.getOper());
            }
            if (token == Token.MULTIPLY) {
                oper.push(parser.getOper());
            }
            if (token == Token.DIVIDE) {
                oper.push(parser.getOper());
            }
            else {
                throw new Exception("Косяки");
            }
        }
        System.out.println(oper);
        System.out.println();
        System.out.println(num);
    }
}