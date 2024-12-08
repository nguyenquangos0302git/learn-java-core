package com.anything.reflection.reflection_with_annotation;

import com.anything.reflection.reflection_with_annotation.annotations.InitializerClass;
import com.anything.reflection.reflection_with_annotation.annotations.InitializerMethod;

@InitializerClass
public class AutoSaver {

    @InitializerMethod
    public void startAutoSavingThreads() {
        System.out.println("Start automatic data saving to disk.");
    }

}
