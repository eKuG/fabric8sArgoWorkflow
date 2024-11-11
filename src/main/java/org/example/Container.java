package org.example;

import lombok.Data;
import java.util.List;

@Data
public class Container {

    private String image;
    private List<String> command;
    private List<String> args;
}