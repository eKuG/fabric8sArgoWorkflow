package org.example;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        KubernetesClient client = new KubernetesClientBuilder().build();
        ArgoWorkflowManager argoWorkflowManager = new ArgoWorkflowManager();
        argoWorkflowManager.submitArgoWorkflow(client);
    }
}