package com.anything.reflection.reflection_with_field.set_value;

import java.lang.reflect.Field;

public class ModifyFieldValue {

    public <T> void setValueField(T instance, String fieldName, String value) throws NoSuchFieldException, IllegalAccessException {
        Class<T> clazz = (Class<T>) instance.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(instance, value);

    }

}
