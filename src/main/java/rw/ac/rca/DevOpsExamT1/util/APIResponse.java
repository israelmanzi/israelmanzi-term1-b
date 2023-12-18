package rw.ac.rca.DevOpsExamT1.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse {
    private Boolean success;
    private Object data;

    public APIResponse(Boolean success, String message) {
        this.success = success;
    }

    public static APIResponse success(Object data) {
        return new APIResponse(true, data);
    }

    public static APIResponse fail(Object data) {
        return new APIResponse(false, data);
    }
}
