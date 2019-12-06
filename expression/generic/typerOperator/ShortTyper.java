package expression.generic.typerOperator;

import expression.exceptions.expressionException.evaluateException.EvaluateException;

public class ShortTyper implements Typer<Short> {
    @Override
    public Short parseStringToValue(String toParse) throws NumberFormatException {
        return new Short(toParse);
    }

    @Override
    public Short parseIntToValue(int toParse) {
        return (short) toParse;
    }

    @Override
    public Short add(Short number1, Short number2) throws EvaluateException {
        return (short) (number1 + number2);
    }

    @Override
    public Short multiply(Short number1, Short number2) throws EvaluateException {
        return (short) (number1 * number2);
    }

    @Override
    public Short divide(Short number1, Short number2) throws EvaluateException {
        return (short) (number1 / number2);
    }

    @Override
    public Short subtract(Short number1, Short number2) throws EvaluateException {
        return (short) (number1 - number2);
    }

    @Override
    public Short negate(Short number) throws EvaluateException {
        return (short) -number;
    }

    @Override
    public Short count(Short number) {
        return (short) Integer.bitCount(0xFFFF & number);
    }

    @Override
    public Short min(Short number1, Short number2) {
        return number1 < number2 ? number1 : number2;
    }

    @Override
    public Short max(Short number1, Short number2) {
        return number1 > number2 ? number1 : number2;
    }
}
