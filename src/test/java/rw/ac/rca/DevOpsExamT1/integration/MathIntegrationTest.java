package rw.ac.rca.DevOpsExamT1.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rw.ac.rca.DevOpsExamT1.dto.DoMathRequest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MathIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMultiplication_success() throws Exception {
        DoMathRequest mathRequest = new DoMathRequest(12, 4, "*");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/math")
                        .contentType("application/json")
                        .content(toJSON(mathRequest)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.data").value(48.0));
    }

    @Test
    public void testDivision_success() throws Exception {
        DoMathRequest mathRequest = new DoMathRequest(12, 4, "/");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/math")
                        .contentType("application/json")
                        .content(toJSON(mathRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(3.0));
    }

    @Test
    public void testDivision_operand2_IsZero_fail() throws Exception {
        DoMathRequest mathRequest = new DoMathRequest(12, 0, "/");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/math")
                        .contentType("application/json")
                        .content(toJSON(mathRequest)))
                .andExpect(status().is5xxServerError())
                .andExpect(jsonPath("$.status").value(500))
                .andExpect(jsonPath("$.error").value("Internal Server Error"))
                .andExpect(jsonPath("$.message").value("Cannot divide by 0"));
    }

    @Test
    public void testAddition_success() throws Exception {
        DoMathRequest mathRequest = new DoMathRequest(12, 4, "+");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/math")
                        .contentType("application/json")
                        .content(toJSON(mathRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(16.0));
    }

    @Test
    public void testSubtraction_success() throws Exception {
        DoMathRequest mathRequest = new DoMathRequest(12, 4, "-");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/math")
                        .contentType("application/json")
                        .content(toJSON(mathRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(8.0));
    }

    @Test
    public void testPower_success() throws Exception {
        DoMathRequest mathRequest = new DoMathRequest(12, 4, "**");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/math")
                        .contentType("application/json")
                        .content(toJSON(mathRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(20736.0));
    }

    @Test
    public void testLog_success() throws Exception {
        DoMathRequest mathRequest = new DoMathRequest(12, 4, "log");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/math")
                        .contentType("application/json")
                        .content(toJSON(mathRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(7.224719895935548));
    }

    @Test
    public void testLn_success() throws Exception {
        DoMathRequest mathRequest = new DoMathRequest(12, 4, "ln");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/math")
                        .contentType("application/json")
                        .content(toJSON(mathRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(16.635532333438686));
    }

    private byte[] toJSON(DoMathRequest data) {
        try {
            return new ObjectMapper().writeValueAsString(data).getBytes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
