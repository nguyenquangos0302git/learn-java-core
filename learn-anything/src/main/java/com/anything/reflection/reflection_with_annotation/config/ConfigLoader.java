package com.anything.reflection.reflection_with_annotation.config;

import com.anything.reflection.reflection_with_annotation.annotations.InitializerClass;
import com.anything.reflection.reflection_with_annotation.annotations.InitializerMethod;

@InitializerClass
public class ConfigLoader {

    @InitializerMethod
    public void loadConfig() {
        System.out.println("Loading all configuration files.");
    }

}
