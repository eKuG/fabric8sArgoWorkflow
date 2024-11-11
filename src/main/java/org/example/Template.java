package org.example;

import lombok.Data;
import java.util.List;

@Data
public class Template {

    private String name;
    private Container container; // Container is a separate class
    // You can add more fields based on other template properties like `steps` or `dags`
}
