package expression.exceptions.expressionException.evaluateException;

public class OverflowException extends EvaluateException {
    String expressionOverflow;

    public OverflowException(String expressionOverflow) {
        this.expressionOverflow = expressionOverflow;
    }

    @Override
    public String getMessage() {
        return "overflow in expression: "+ expressionOverflow;
    }
}
