package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkflowStatus {
    private List<Condition> conditions;
    private String workflowStatus;

    public static class Condition {
        private String type;
        private String status;
        // other properties, getters, and setters
    }

}

