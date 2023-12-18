package rw.ac.rca.DevOpsExamT1.service;

import rw.ac.rca.DevOpsExamT1.util.InvalidOperationException;

public abstract class MathOperator {
    protected abstract double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}
