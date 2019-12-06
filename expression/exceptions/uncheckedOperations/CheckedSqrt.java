package expression.exceptions.BinaryOperation.unchecked;

import expression.TripleExpression;
import expression.exceptions.unaryOperations.UnaryOperation;
import expression.exceptions.expressionException.evaluateException.EvaluateException;
import expression.exceptions.expressionException.evaluateException.IllegalArgumentExpression;

public strictfp class CheckedSqrt extends UnaryOperation {


    public CheckedSqrt(TripleExpression tripleExpression) {
        super(tripleExpression);
    }

    @Override
    protected int doOperation(int x) throws EvaluateException {
        if (x < 0) {
            throw new IllegalArgumentExpression(x);
        } else {
            int left = 0;
            int right = 46341;
            while (right - left > 1) {
                int m = (left + right) >> 1;
                if (m * m <= x) {
                    left = m;
                } else {
                    right = m;
                }
            }
            return left;
        }
    }
}
