package rw.ac.rca.DevOpsExamT1.service;

import org.junit.jupiter.api.Test;
import rw.ac.rca.DevOpsExamT1.serviceImpl.MathOperatorImpl;
import rw.ac.rca.DevOpsExamT1.util.InvalidOperationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathOperatorImplTest {
    private int operand1 = 10;
    private int operand2 = 3;
    @Test
    public void performMultiplication_success() throws InvalidOperationException {
        MathOperatorImpl mathOperator = new MathOperatorImpl();

        double actualResult = mathOperator.doMath(operand1, operand2, "*");
        double result = 30.0;

        assertEquals(actualResult, result);
    }

    @Test
    public void performDivision_success() throws InvalidOperationException {
        MathOperatorImpl mathOperator = new MathOperatorImpl();

        double actualResult = mathOperator.doMath(operand1, operand2, "/");
        double result = 3.3333333333333335;

        assertEquals(actualResult, result);
    }

    @Test
    public void performDivision_whenOperand2_IsZero() throws InvalidOperationException {
        MathOperatorImpl mathOperator = new MathOperatorImpl();


        assertThrows(InvalidOperationException.class, () -> {
            mathOperator.doMath(operand1, operand2, "/");
        });
    }

    @Test
    public void performAddition_success() throws InvalidOperationException {
        MathOperatorImpl mathOperator = new MathOperatorImpl();

        double actualResult = mathOperator.doMath(operand1, operand2, "+");
        double result = 13.0;

        assertEquals(actualResult, result);
    }

    @Test
    public void performSubtraction_success() throws InvalidOperationException {
        MathOperatorImpl mathOperator = new MathOperatorImpl();

        double actualResult = mathOperator.doMath(operand1, operand2, "-");
        double result = 7.0;

        assertEquals(actualResult, result);
    }

    @Test
    public void performPowering_success() throws InvalidOperationException {
        MathOperatorImpl mathOperator = new MathOperatorImpl();

        double actualResult = mathOperator.doMath(operand1, operand2, "**");
        double result = 1000.0;

        assertEquals(actualResult, result);
    }

    @Test
    public void performLog_success() throws InvalidOperationException {
        MathOperatorImpl mathOperator = new MathOperatorImpl();

        double actualResult = mathOperator.doMath(operand1, operand2, "log");
        double result = 4.771212547196624;

        assertEquals(actualResult, result);
    }

    @Test
    public void performLn_success() throws InvalidOperationException {
        MathOperatorImpl mathOperator = new MathOperatorImpl();

        double actualResult = mathOperator.doMath(operand1, operand2, "ln");
        double result = 10.986122886681098;

        assertEquals(actualResult, result);
    }
}
