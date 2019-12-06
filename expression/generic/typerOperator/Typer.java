package expression.generic.typerOperator;

import expression.exceptions.expressionException.evaluateException.EvaluateException;

public interface Typer<T> {
    T parseStringToValue(String toParse) throws NumberFormatException;

    T parseIntToValue(int toParse);

    T add(T number1, T number2) throws EvaluateException;

    T multiply(T number1, T number2) throws EvaluateException;

    T divide(T number1, T number2) throws EvaluateException;

    T subtract(T number1, T number2) throws EvaluateException;

    T negate(T number) throws EvaluateException;

    T min(T number1, T number2);

    T max(T number1, T number2);

    T count(T number);
}
