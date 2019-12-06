package expression.exceptions.expressionException.evaluateException;

public class IllegalArgumentExpression extends EvaluateException {
    int num;

    public IllegalArgumentExpression(int num) {
        this.num = num;
    }



    @Override
    public String getMessage() {
        return "Your attempt to extract the root from negative number=" + num + " is failed!";
    }
}
