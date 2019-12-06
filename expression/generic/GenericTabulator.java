package expression.generic;

import expression.TripleExpression;
import expression.exceptions.ExpressionParser;
import expression.exceptions.Parser;
import expression.exceptions.expressionException.evaluateException.EvaluateException;
import expression.exceptions.expressionException.parserException.ParserException;
import expression.exceptions.tabulatorException.UnknownModeException;
import expression.generic.typerOperator.*;
import expression.generic.typerOperator.IntegerTyper;

public class GenericTabulator implements Tabulator {

    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception {
        Typer<?> typer;
        switch (mode) {
            case "i":
                typer = new IntegerTyper(true);
                break;
            case "d":
                typer = new DoubleTyper();
                break;
            case "bi":
                typer = new BigIntegerTyper();
                break;
            case "u":
                typer = new IntegerTyper(false);
                break;
            case "l":
                typer = new LongTyper();
                break;
            case "s":
                typer = new ShortTyper();
                break;
            default:
                throw new UnknownModeException(mode);
        }
        return buildTable(expression, typer, x1, x2, y1, y2, z1, z2);
    }

    private <T> Object[][][] buildTable(String stringExpression, Typer<T> typer, int x1, int x2, int y1, int y2, int z1, int z2) throws EvaluateException, ParserException {
        TripleExpression<T> expression = getExpression(typer, stringExpression);
        Object[][][] resultTable = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                for (int z = z1; z <= z2; z++) {
                    try{
                        resultTable[x - x1][y - y1][z - z1] = expression.evaluate(typer.parseIntToValue(x), typer.parseIntToValue(y), typer.parseIntToValue(z));
                    } catch (EvaluateException|ArithmeticException e ){
                        resultTable[x - x1][y - y1][z - z1] = null;
                    }
                }
            }
        }
        return resultTable;
    }

    private <T> TripleExpression<T> getExpression(Typer<T> typer, String expression) throws ParserException {
        Parser<T> parser = new ExpressionParser<>(typer);
        TripleExpression<T> tTripleExpression = parser.parse(expression);
        return tTripleExpression;
    }
}
