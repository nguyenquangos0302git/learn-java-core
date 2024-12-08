package com.anything.reflection.reflection_with_annotation.database;

import com.anything.reflection.reflection_with_annotation.annotations.InitializerClass;
import com.anything.reflection.reflection_with_annotation.annotations.InitializerMethod;

@InitializerClass
public class CacheLoader {

    @InitializerMethod
    public void loadCache() {
        System.out.println("Loading data from cache");
    }

    @InitializerMethod
    public void reloadCache() {
        System.out.println("Reload cache");
    }
}
