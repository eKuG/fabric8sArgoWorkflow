package org.example;

import io.fabric8.kubernetes.api.model.KubernetesResource;
import lombok.Data;

@Data
public class WorkflowSpec implements KubernetesResource {

    private Object entrypoint;
    private Object arguments;
    private Object templates;
    private Object volumes;
    private Object serviceAccountName;
    private Object activeDeadlineSeconds;
    private Object hostNetwork;
    private Object ttlSecondsAfterFinished;
}