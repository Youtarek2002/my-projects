package com.example.calculator;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;

@Service
public class parsing {

    public double evaluate(String expression) {
        //String expression = "5+3*2^2-8/2"; // Example expression without spaces

        // Add spaces between operators and operands to enable parsing by SpEL
        //expression = expression.replaceAll("(?<=[^\\d.])(?=\\d)", " ")
          //      .replaceAll("(?<=\\d)(?=[^\\d.])", " ");
        expression = expression.replaceAll("/","*1.0/");
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(expression);

        Double result = exp.getValue(Double.class);
        return result;
    }
}

