package org.example;

import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class ArgoWorkflowManager {

    public InputStream createArgoSpec() {
        InputStream inputStream = getClass().getResourceAsStream("/argo-workflow.yaml");
        if (inputStream == null) {
            System.out.println("YAML file not found in resources. Please check the file path.");
            throw new IllegalArgumentException("Cannot find argo-workflow.yaml");
        }
        return inputStream;
    }

    public Workflow submitArgoWorkflow(KubernetesClient client) {
        MixedOperation<Workflow, KubernetesResourceList<Workflow>, Resource<Workflow>>
                workflowClient = client.resources(Workflow.class);

        Workflow workflow = new Workflow();
        workflow.setSpec(createWorkflowSpec());
        workflow.setStatus(new WorkflowStatus());
        workflow.getMetadata().setName("hello-world-" + System.currentTimeMillis());
        workflow.getMetadata().setNamespace("argo");

        Workflow createdWorkflow = workflowClient.inNamespace("argo").create(workflow);
        System.out.println(createdWorkflow.getMetadata().getName());
        return createdWorkflow;
    }

    public WorkflowSpec createWorkflowSpec() {
        // Create a container instance
        Container helloWorldContainer = new Container();
        helloWorldContainer.setImage("busybox");
        helloWorldContainer.setCommand(List.of("echo"));
        helloWorldContainer.setArgs(List.of("hello world"));

        // Create a template for the hello-world task
        Template helloWorldTemplate = new Template();
        helloWorldTemplate.setName("hello-world");
        helloWorldTemplate.setContainer(helloWorldContainer);

        // Create the WorkflowSpec and set the entrypoint and templates
        WorkflowSpec spec = new WorkflowSpec();
        spec.setEntrypoint("hello-world");
        spec.setTemplates(List.of(helloWorldTemplate));  // Set the template list

        // Set other fields as needed (e.g., arguments, volumes, etc.)
        return spec;
    }
}
