package expression.generic.typerOperator;

import expression.exceptions.expressionException.evaluateException.EvaluateException;

public class LongTyper implements Typer<Long> {
    @Override
    public Long parseStringToValue(String toParse) throws NumberFormatException {
        return new Long(toParse);
    }

    @Override
    public Long parseIntToValue(int toParse) {
        return new Long(toParse);
    }

    @Override
    public Long add(Long number1, Long number2) throws EvaluateException {
        return number1 + number2;
    }

    @Override
    public Long multiply(Long number1, Long number2) throws EvaluateException {
        return number1 * number2;
    }

    @Override
    public Long divide(Long number1, Long number2) throws EvaluateException {
        return number1 / number2;
    }

    @Override
    public Long subtract(Long number1, Long number2) throws EvaluateException {
        return number1 - number2;
    }

    @Override
    public Long negate(Long number) throws EvaluateException {
        return -number;
    }

    @Override
    public Long count(Long number) {
        Long.bitCount(number);
        return (long) Long.bitCount(number);
    }

    @Override
    public Long min(Long number1, Long number2) {
        return number1 < number2 ? number1 : number2;
    }

    @Override
    public Long max(Long number1, Long number2) {
        return number1 > number2 ? number1 : number2;
    }
}
