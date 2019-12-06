package expression.generic.typerOperator;

import java.lang.Double;

import expression.exceptions.expressionException.evaluateException.EvaluateException;

public class DoubleTyper implements Typer<Double> {
    @Override
    public Double parseIntToValue(int toParse) {
        return new Double(toParse);
    }

    @Override
    public Double count(Double number) {
        return (double)Long.bitCount(Double.doubleToLongBits(number));
    }

    @Override
    public Double min(Double number1, Double number2) {
        return (number1 < number2) ? number1 : number2;
    }

    @Override
    public Double max(Double number1, Double number2) {
        return (number1 > number2) ? number1 : number2;
    }

    @Override
    public Double negate(Double number) throws EvaluateException {
        return -number;
    }

    @Override
    public Double parseStringToValue(String toParse) throws NumberFormatException {
        return new Double(toParse);
    }

    @Override
    public Double add(Double number1, Double number2) throws EvaluateException {
        return number1 + number2;
    }

    @Override
    public Double multiply(Double number1, Double number2) throws EvaluateException {
        return number1 * number2;
    }

    @Override
    public Double divide(Double number1, Double number2) throws EvaluateException {
        return number1 / number2;
    }

    @Override
    public Double subtract(Double number1, Double number2) throws EvaluateException {
        return number1 - number2;
    }
}
