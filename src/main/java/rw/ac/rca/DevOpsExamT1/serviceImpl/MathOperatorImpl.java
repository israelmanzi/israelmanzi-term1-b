package rw.ac.rca.DevOpsExamT1.serviceImpl;

import org.springframework.stereotype.Service;
import rw.ac.rca.DevOpsExamT1.service.MathOperator;
import rw.ac.rca.DevOpsExamT1.util.InvalidOperationException;

@Service
public class MathOperatorImpl extends MathOperator {
    @Override
    public double doMath(double operand1, double operand2, String operation) throws InvalidOperationException {
        if ("/".equals(operation) && (operand2 == 0 || operand2 == (double) 0)) {
            throw new InvalidOperationException("Cannot divide by 0");
        }

        switch (operation) {
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "**":
                return Math.pow(operand1, operand2);
            case "log":
                return operand1 * Math.log10(operand2);
            case "ln":
                return operand1 * Math.log(operand2);
            default:
                throw new RuntimeException("Unknown Operation");
        }
    }
}
