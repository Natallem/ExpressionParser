package expression.exceptions.expressionException.parserException;

public class LackOfBracesException extends ParserException {

    int absenceOfBrace;

    public LackOfBracesException(int index, String expression, int absenceIndex) {
        super(index, expression);
        absenceOfBrace = absenceIndex;
    }

    @Override
    public String getMessage() {
        return String.format("Error in expression \"%s\".%n" +
                        "No close brace for expression \"%s\".",
                expression, expression.substring(index, absenceOfBrace-1));
    }

}
