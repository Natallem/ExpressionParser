package expression.exceptions.expressionException.parserException;

public class InvalidSequenceOfCharacters extends ParserException {

    String letters;

    public InvalidSequenceOfCharacters(int index, String expression, String letters) {
        super(index, expression);
        this.letters = letters;
    }

    @Override
    public String getMessage() {
        return String.format("Error in expression \"%s\".%nImpossible to parse \"%s\" because of unknown characters sequence: \"%s\".",
                expression, expression.substring(index), letters);
    }
}
