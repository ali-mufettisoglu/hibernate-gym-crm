package org.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:application.properties")
@ComponentScan(basePackages = {"org.example"})
public class SpringConfig {

}

