package com.lixin.interpreter;

import com.lixin.lexer.Token;

/**
 * @author lixin
 */
public class And extends Logical {
    public And(Token token, Expression node1, Expression node2) {
        super(token, node1, node2);
    }

    @Override
    public void jumping(int positive, int negative) {
        int label = negative != 0 ? negative : newLabel();
        expression1.jumping(0, negative);
        expression2.jumping(positive, negative);
        if (negative == 0) {
            emitLabel(label);
        }
    }
}
