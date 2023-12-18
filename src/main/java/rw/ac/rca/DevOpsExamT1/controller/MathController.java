package rw.ac.rca.DevOpsExamT1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.ac.rca.DevOpsExamT1.dto.DoMathRequest;
import rw.ac.rca.DevOpsExamT1.serviceImpl.MathOperatorImpl;
import rw.ac.rca.DevOpsExamT1.util.APIResponse;
import rw.ac.rca.DevOpsExamT1.util.InvalidOperationException;

@RestController
@RequestMapping("/api/math")
public class MathController {
    private final MathOperatorImpl mathOperatorImpl;

    public MathController(MathOperatorImpl mathOperatorImpl) {
        this.mathOperatorImpl = mathOperatorImpl;
    }

    @PostMapping
    public ResponseEntity<APIResponse> create(@RequestBody DoMathRequest dto) throws InvalidOperationException {
        return ResponseEntity.ok(APIResponse.success(mathOperatorImpl.doMath(dto.getOperand1(), dto.getOperand2(), dto.getOperation())));
    }
}
