package expression.generic.typerOperator;

import java.math.BigInteger;

import expression.exceptions.expressionException.evaluateException.EvaluateException;

public class BigIntegerTyper implements Typer<BigInteger> {
    @Override
    public BigInteger parseIntToValue(int toParse) {
        return BigInteger.valueOf(toParse);
    }

    @Override
    public BigInteger min(BigInteger number1, BigInteger number2) {
        return number1.min(number2);
    }

    @Override
    public BigInteger max(BigInteger number1, BigInteger number2) {
        return number1.max(number2);
    }

    @Override
    public BigInteger parseStringToValue(String toParse) throws NumberFormatException {
        return new BigInteger(toParse);
    }

    @Override
    public BigInteger count(BigInteger number) {
        return BigInteger.valueOf(number.bitCount());
    }

    @Override
    public BigInteger negate(BigInteger number) throws EvaluateException {
        return number.multiply(BigInteger.valueOf(-1));
    }

    @Override
    public BigInteger add(BigInteger number1, BigInteger number2) throws EvaluateException {
        return number1.add(number2);
    }

    @Override
    public BigInteger multiply(BigInteger number1, BigInteger number2) throws EvaluateException {
        return number1.multiply(number2);
    }

    @Override
    public BigInteger divide(BigInteger number1, BigInteger number2) throws EvaluateException {
        return number1.divide(number2);
    }

    @Override
    public BigInteger subtract(BigInteger number1, BigInteger number2) throws EvaluateException {
        return number1.subtract(number2);
    }
}
