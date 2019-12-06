package expression.generic.typerOperator;

import java.lang.Integer;

import expression.exceptions.expressionException.evaluateException.DivisionByZeroException;
import expression.exceptions.expressionException.evaluateException.EvaluateException;
import expression.exceptions.expressionException.evaluateException.OverflowException;

public class IntegerTyper implements Typer<Integer> {
    private boolean checkedMode;

    public IntegerTyper(boolean isCheckedInteger) {
        checkedMode = isCheckedInteger;
    }

    @Override
    public Integer parseIntToValue(int toParse) {
        return toParse;
    }

    @Override
    public Integer min(Integer number1, Integer number2) {
        return number1 < number2 ? number1 : number2;
    }

    @Override
    public Integer max(Integer number1, Integer number2) {
        return number1 > number2 ? number1 : number2;
    }

    @Override
    public Integer negate(Integer number) throws EvaluateException {
        if (checkedMode) {
            checkNegate(number);
        }
        return -number;
    }

    private void checkNegate(Integer number) throws OverflowException {
        if (number == Integer.MIN_VALUE) {
            throw new OverflowException("-" + number);
        }
    }

    @Override
    public Integer parseStringToValue(String toParse) throws NumberFormatException {
        return new Integer(toParse);
    }

    @Override
    public Integer add(Integer number1, Integer number2) throws EvaluateException {
        if (checkedMode) {
            checkAdd(number1, number2);
        }
        return number1 + number2;
    }

    private void checkAdd(Integer number1, Integer number2) throws OverflowException {
        if ((number1 > 0 && number2 > 0 && number1 > Integer.MAX_VALUE - number2) ||
                (number1 < 0 && number2 < 0 && number1 < Integer.MIN_VALUE - number2)) {
            throw new OverflowException(number1 + "+" + number2);
        }
    }


    @Override
    public Integer multiply(Integer number1, Integer number2) throws EvaluateException {
        if (checkedMode) {
            if (number1 < number2) {
                int temp = number1;
                number1 = number2;
                number2 = temp;
            }
            checkMultiply(number1, number2);
        }
        return number1 * number2;
    }

    private void checkMultiply(Integer number1, Integer number2) throws OverflowException {
        if ((number1 < 0 && number1 < Integer.MAX_VALUE / number2) ||
                (number1 > 0 && number2 < 0 && Integer.MIN_VALUE / number1 > number2) ||
                (number2 > 0 && number1 > Integer.MAX_VALUE / number2))
            throw new OverflowException(number1 + "*" + number2);
    }

    @Override
    public Integer divide(Integer number1, Integer number2) throws EvaluateException {
        if (checkedMode) {
            checkDivide(number1, number2);
        }
        return (number1 / number2);
    }

    private void checkDivide(Integer number1, Integer number2) throws EvaluateException {
        if (number2 == 0) throw new DivisionByZeroException(number1 + " / " + number2);
        if (number1 == Integer.MIN_VALUE && number2 == -1) {
            throw new OverflowException(number1 + "/" + number2);
        }
    }

    @Override
    public Integer subtract(Integer number1, Integer number2) throws EvaluateException {
        if (checkedMode) checkSubtract(number1, number2);
        return number1 - number2;
    }

    private void checkSubtract(Integer number1, Integer number2) throws OverflowException {
        if ((number1 >= 0 && number2 < 0 && number1 > Integer.MAX_VALUE + number2) ||
                (number1 < 0 && number2 > 0 && number1 < Integer.MIN_VALUE + number2)) {
            throw new OverflowException(number1 + "-" + number2);
        }
    }

    @Override
    public Integer count(Integer number) {
        return Integer.bitCount(number);
    }
}
