package rw.ac.rca.DevOpsExamT1.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import rw.ac.rca.DevOpsExamT1.dto.DoMathRequest;
import rw.ac.rca.DevOpsExamT1.util.APIResponse;
import rw.ac.rca.DevOpsExamT1.util.InvalidOperationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testMath_operation_success() throws InvalidOperationException {
        DoMathRequest mathRequest = new DoMathRequest(12, 4, "/");

        ResponseEntity<APIResponse> response = this.restTemplate.postForEntity(
                "/api/math",
                mathRequest,
                APIResponse.class
        );

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(3.0, response.getBody().getData());
    }
}
