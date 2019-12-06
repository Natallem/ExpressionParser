package expression.exceptions;

import expression.*;
import expression.Operations.BinaryOperations.*;
import expression.Operations.Const;
import expression.Operations.UnaryOperations.CheckedCount;
import expression.Operations.Variable;
import expression.exceptions.expressionException.parserException.*;
import expression.Operations.UnaryOperations.CheckedNegate;
import expression.generic.typerOperator.Typer;


import java.util.EnumSet;

public class ExpressionParser<T> implements Parser<T> {

    private String expression;
    private Token token;
    private int pointer;
    private String nameOfVar;
    private T valueOfConst;
    private int counterOfOpenBraces;
    private int counterOfCloseBraces;
    private Typer<T> typer;

    public ExpressionParser(Typer<T> typer) {
        this.typer = typer;
    }

    public enum Token {
        CONST, VAR, NEG, ADD, SUB, MUL, DIV, OPEN_BRACE, CLOSE_BRACE, END, BEG, AND, COUNT, ABS, SQRT, MIN, MAX;
    }

    private static EnumSet<Token> binaryOperations = EnumSet.of(Token.ADD, Token.SUB, Token.MUL, Token.DIV, Token.MAX, Token.MIN);

    private static EnumSet<Token> unaryOperations = EnumSet.of(Token.NEG);

    private void skipSpaces() {

        while (pointer < expression.length() && Character.isWhitespace(expression.charAt(pointer))) {
            pointer++;
        }
    }

    private void checkPreviousIsOperation(int indexStartOfError) throws NoOperationException {
        if (token == Token.CLOSE_BRACE || token == Token.VAR || token == Token.CONST) {
            throw new NoOperationException(indexStartOfError, expression);
        }
    }

    private void checkPreviousIsArgument(int indexStartOfError) throws NoArgumentExpression {
        if (binaryOperations.contains(token) || unaryOperations.contains(token) ||
                token == Token.OPEN_BRACE || token == Token.BEG) {
            throw new NoArgumentExpression(indexStartOfError, expression);
        }
    }

    private String readString() {
        int beginOfLetters = pointer;
        while (pointer < expression.length() && Character.isLetter(expression.charAt(pointer))) {
            pointer++;
        }
        pointer--;
        return expression.substring(beginOfLetters, pointer + 1);
    }

    private void checkSpace(int index) throws ParserException {
        if (index + 1 >= expression.length()) {
            throw new NoArgumentExpression(index + 1, expression);
        }
        char nextChar = expression.charAt(index + 1);
        if (!(Character.isWhitespace(nextChar) || (nextChar == '-'))) {
            throw new NoArgumentExpression(index + 1, expression);
        }
    }

    private String getNum() {
        int res;
        boolean isNeg = false;
        if (expression.charAt(pointer) == '-') {
            pointer++;
            skipSpaces();
            isNeg = true;
        }
        int beginOfNum = pointer;
        while (pointer < expression.length() && Character.isDigit(expression.charAt(pointer))) {
            pointer++;
        }
        pointer--;
        String toParse;
        if (isNeg) {
            toParse = '-' + expression.substring(beginOfNum, pointer + 1);
        } else {
            toParse = expression.substring(beginOfNum, pointer + 1);
        }
        /*try {
            res = Integer.parseInt(toParse);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(toParse);
        }*/
        return toParse;
    }

    private void getToken() throws ParserException {
        skipSpaces();
        char curChar;
        if (pointer >= expression.length()) {
            token = Token.END;
        } else {
            curChar = expression.charAt(pointer);
            switch (curChar) {

                case '(':
                    checkPreviousIsOperation(pointer);
                    counterOfOpenBraces++;
                    token = Token.OPEN_BRACE;
                    break;

                case ')':
                    checkPreviousIsArgument(pointer);
                    counterOfCloseBraces++;
                    token = Token.CLOSE_BRACE;
                    if (counterOfCloseBraces > counterOfOpenBraces) {
                        throw new ExtraBracesException(pointer, expression);
                    }
                    break;

                case '+':
                    checkPreviousIsArgument(pointer);
                    token = Token.ADD;
                    break;

                case '*':
                    checkPreviousIsArgument(pointer);
                    token = Token.MUL;
                    break;

                case '/':
                    checkPreviousIsArgument(pointer);
                    token = Token.DIV;
                    break;

                case '-':
                    if (token == Token.CONST || token == Token.VAR || token == Token.CLOSE_BRACE) {
                        token = Token.SUB;
                    } else {
                        int indexBeforeError = pointer;
                        if (pointer + 1 == expression.length())
                            throw new NoArgumentExpression(indexBeforeError, expression);
                        if (Character.isDigit(expression.charAt(pointer + 1))) {
                            try {
                                valueOfConst = typer.parseStringToValue(getNum());
                                token = Token.CONST;
                            } catch (NumberFormatException ex) {
                                throw new ConstantOverflowException(ex, indexBeforeError, expression);
                            }
                        } else {
                            token = Token.NEG;
                        }
                    }
                    break;

                default:
                    int indexBeforeError = pointer;
                    if (Character.isDigit(curChar)) {
                        checkPreviousIsOperation(indexBeforeError);
                        try {
                            valueOfConst = typer.parseStringToValue(getNum());
                            token = Token.CONST;
                        } catch (NumberFormatException ex) {
                            throw new ConstantOverflowException(ex, indexBeforeError, expression);
                        }
                    } else if (Character.isLetter(curChar)) {
                        String letters = readString();
                        if (letters.equals("x") || letters.equals("y") || letters.equals("z")) {
                            checkPreviousIsOperation(indexBeforeError);
                            nameOfVar = letters;
                            token = Token.VAR;
                        } else {
                            switch (letters) {
                                case "abs":
                                    checkPreviousIsOperation(indexBeforeError);
                                    token = Token.ABS;
                                    break;
                                case "sqrt":
                                    checkPreviousIsOperation(indexBeforeError);
                                    token = Token.SQRT;
                                    break;
                                case "count":
                                    checkPreviousIsOperation(indexBeforeError);
                                    token = Token.COUNT;
                                    break;
                                case "min":
                                    checkPreviousIsArgument(indexBeforeError);
                                    checkSpace(pointer);
                                    token = Token.MIN;
                                    break;
                                case "max":
                                    checkPreviousIsArgument(indexBeforeError);
                                    checkSpace(pointer);
                                    token = Token.MAX;
                                    break;
                                default:
                                    throw new InvalidSequenceOfCharacters(indexBeforeError, expression, letters);
                            }
                        }
                    } else {
                        throw new InvalidSequenceOfCharacters(pointer, expression, expression.substring(pointer));
                    }
                    break;
            }
        }
        pointer++;
    }


    private TripleExpression<T> getUnaryExp() throws ParserException {
        getToken();
        switch (token) {

            case CONST:
                getToken();
                return new Const<>(valueOfConst);

            case VAR:
                getToken();
                return new Variable<>(nameOfVar);

            case NEG:
                return new CheckedNegate<>(getUnaryExp(), typer);

            case COUNT:
                return new CheckedCount<>(getUnaryExp(), typer);

            case OPEN_BRACE:
                int indexBeforeError = pointer;
                TripleExpression<T> result = getAnyExpression();
                if (token != Token.CLOSE_BRACE)
                    throw new LackOfBracesException(indexBeforeError - 1, expression, pointer);
                getToken();
                return result;

            default:
                throw new NoArgumentExpression(pointer, expression);
        }
    }

    private TripleExpression<T> getDivOrMul() throws ParserException {
        TripleExpression<T> result = getUnaryExp();
        do {
            switch (token) {

                case DIV:
                    result = new CheckedDivide<>(result, getUnaryExp(), typer);
                    break;

                case MUL:
                    result = new CheckedMultiply<>(result, getUnaryExp(), typer);
                    break;

                default:
                    return result;
            }
        } while (true);
    }

    private TripleExpression<T> getAddOrSub() throws ParserException {

        TripleExpression<T> result = getDivOrMul();

        do {
            switch (token) {

                case ADD:
                    result = new CheckedAdd<>(result, getDivOrMul(), typer);
                    break;

                case SUB:
                    result = new CheckedSubtract<>(result, getDivOrMul(), typer);
                    break;

                default:
                    return result;
            }
        } while (true);
    }

    private TripleExpression<T> getMinOrMax() throws ParserException {

        TripleExpression<T> result = getAddOrSub();

        do {
            switch (token) {

                case MIN:
                    result = new CheckedMin<>(result, getAddOrSub(), typer);
                    break;

                case MAX:
                    result = new CheckedMax<>(result, getAddOrSub(), typer);
                    break;

                default:
                    return result;
            }
        } while (true);
    }


    private TripleExpression<T> getAnyExpression() throws ParserException {
        return getMinOrMax();
    }

    public TripleExpression<T> parse(String expression) throws ParserException {
        counterOfOpenBraces = 0;
        counterOfCloseBraces = 0;
        this.expression = expression;
        pointer = 0;
        token = Token.BEG;
        TripleExpression<T> result = getAnyExpression();
        skipSpaces();
        if (pointer < expression.length()) {
            throw new WrongConstructionOfExpression(pointer, expression);
        }
        if (counterOfCloseBraces != counterOfOpenBraces) throw new ExtraBracesException(pointer, expression);
        return result;
    }
}