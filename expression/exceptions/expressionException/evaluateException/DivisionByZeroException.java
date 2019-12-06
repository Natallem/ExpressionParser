package expression.exceptions.expressionException.evaluateException;

public class DivisionByZeroException extends EvaluateException {

    String wrongDivision;

    public DivisionByZeroException(String wrongDivision) {
        this.wrongDivision = wrongDivision;
    }

    @Override
    public String getMessage() {
        return "Attempt to divide by zero: "+ wrongDivision;
    }
}
