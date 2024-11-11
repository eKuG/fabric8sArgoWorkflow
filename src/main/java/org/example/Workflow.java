package org.example;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Version("v1alpha1")
@Group("argoproj.io")
public class Workflow extends CustomResource<WorkflowSpec, WorkflowStatus> implements Namespaced {

    private WorkflowSpec spec;
    private WorkflowStatus status;

}