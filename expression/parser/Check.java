package expression.parser;

import expression.TripleExpression;
import expression.exceptions.unchecked.ExpressionParser;

public class Check {
    public static void main(String[] args) throws Exception {
        ExpressionParser parser = new ExpressionParser();
        TripleExpression expression = parser.parse("(4*2/1*x+4(2+3))");
        System.out.println(expression.evaluate(1,2,4));


    }
}
