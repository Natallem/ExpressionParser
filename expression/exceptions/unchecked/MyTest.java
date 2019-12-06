package expression.exceptions.unchecked;

import expression.TripleExpression;
import expression.exceptions.Parser;
import expression.exceptions.expressionException.evaluateException.*;
import expression.exceptions.expressionException.parserException.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyTest {
    public static void main(String[] args) throws ParserException, EvaluateException, IOException {
        boolean fastTest = true;
        if (fastTest) {
            System.out.println(new ExpressionParser().parse("x*()").evaluate(1000000,678,5));
        } else {
            Parser parser = new ExpressionParser();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String expression;
            int[] xyz = new int[3];

            while (true) {
                System.out.println("Input your expression");
                expression = reader.readLine();

                try {
                    TripleExpression tripleExpression = parser.parse(expression);
                    for (int i = 0; i < 3; i++) {
                        int numOfChar = 'x' + i;
                        char curChar = (char) numOfChar;
                        System.out.println("Input value of " + curChar);
                        xyz[i] = Integer.parseInt(reader.readLine());
                    }
                    try {
                        System.out.println("result=" + tripleExpression.evaluate(xyz[0], xyz[1], xyz[2]));
                    } catch (EvaluateException e) {
                        System.out.println("Error while evaluate:");
                        System.out.println(e.getMessage());
                    }
                } catch (ParserException e) {
                    System.out.println("Error while parsing:");
                    System.out.println(e.getMessage());
                }
                System.out.println("Write \"1\" to continue");
                if (Integer.parseInt(reader.readLine()) != 1) break;

            }
            System.out.println("Goodbye!");
        }
    }
}
