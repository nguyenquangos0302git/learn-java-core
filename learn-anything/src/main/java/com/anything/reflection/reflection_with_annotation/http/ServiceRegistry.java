package com.anything.reflection.reflection_with_annotation.http;

import com.anything.reflection.reflection_with_annotation.annotations.InitializerClass;
import com.anything.reflection.reflection_with_annotation.annotations.InitializerMethod;

@InitializerClass
public class ServiceRegistry {

    @InitializerMethod
    public void registerService() {
        System.out.println("Service successfully registered");
    }
}
