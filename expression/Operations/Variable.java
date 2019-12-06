package expression.Operations;

import expression.TripleExpression;

public strictfp  class  Variable<T>  implements TripleExpression<T> {

    String name;

    public Variable(String newName) {
        name = newName;
    }

    public T evaluate(T x, T y, T z) {
        T res;
        switch (this.name) {
            case "x":
                res = x;
                break;
            case "y":
                res = y;
                break;
            case "z":
                res = z;
                break;
            default:
                res = null;
                break;
        }
        return res;
    }
}
