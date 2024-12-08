package com.anything.reflection.reflection_with_class;

import java.util.Arrays;
import java.util.List;

public class ClassAnalyzer {

    private static final List<String> JDK_PACKAGE_PREFIXES =
            Arrays.asList("com.sun.", "java", "javax", "jdk", "org.w3c", "org.xml");

    public static void main(String[] args) {
        System.out.println(createPopupTypeInfoFromClass(String.class));
    }

    public static PopupTypeInfo createPopupTypeInfoFromClass(Class<?> inputClass) {
        PopupTypeInfo popupTypeInfo = new PopupTypeInfo();

        popupTypeInfo.setPrimitive(inputClass.isPrimitive())
                .setInterface(inputClass.isInterface())
                .setEnum(inputClass.isEnum())
                .setName(inputClass.getSimpleName())
                .setJdk(isJdkClass(inputClass));

        return popupTypeInfo;
    }

    /*********** Helper Methods ***************/

    public static boolean isJdkClass(Class<?> inputClass) {
        String packageName = inputClass.getPackageName();

        return JDK_PACKAGE_PREFIXES.stream()
                .anyMatch(packagePrefix -> packageName.startsWith(packagePrefix));
    }

    private static class PopupTypeInfo {
        private boolean isPrimitive;
        private boolean isInterface;
        private boolean isEnum;

        private String name;
        private boolean isJdk;

        public PopupTypeInfo setPrimitive(boolean isPrimitive) {
            this.isPrimitive = isPrimitive;
            return this;
        }

        public PopupTypeInfo setInterface(boolean isInterface) {
            this.isInterface = isInterface;
            return this;
        }

        public PopupTypeInfo setEnum(boolean isEnum) {
            this.isEnum = isEnum;
            return this;
        }

        public PopupTypeInfo setName(String name) {
            this.name = name;
            return this;
        }

        public PopupTypeInfo setJdk(boolean isJdkType) {
            this.isJdk = isJdkType;
            return this;
        }

        public boolean isPrimitive() {
            return isPrimitive;
        }

        public boolean isInterface() {
            return isInterface;
        }

        public boolean isEnum() {
            return isEnum;
        }

        public String getName() {
            return name;
        }

        public boolean isJdk() {
            return isJdk;
        }


        @Override
        public String toString() {
            return "PopupTypeInfo{" +
                    "isPrimitive=" + isPrimitive +
                    ", isInterface=" + isInterface +
                    ", isEnum=" + isEnum +
                    ", name='" + name + '\'' +
                    ", isJdk=" + isJdk +
                    '}';
        }
    }

}
