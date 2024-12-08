package com.anything.reflection.reflection_with_method;

import com.anything.reflection.reflection_with_method.database.DatabaseClient;
import com.anything.reflection.reflection_with_method.http.HttpClient;
import com.anything.reflection.reflection_with_method.logging.FileLogger;
import com.anything.reflection.reflection_with_method.udp.UdpClient;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Throwable {
        DatabaseClient databaseClient = new DatabaseClient();
        HttpClient httpClient1 = new HttpClient("123.467.789.0");
        HttpClient httpClient2 = new HttpClient("11.33.55.0");
        FileLogger fileLogger = new FileLogger();
        UdpClient udpClient = new UdpClient();

        String requestBody = "request data";
        List<Class<?>> methodParameterTypes = Arrays.asList(new Class[] {String.class});
        Map<Object, Method> requestExecutors = groupExecutors(Arrays.asList(databaseClient, httpClient1, httpClient2, fileLogger, udpClient), methodParameterTypes);
        executeAll(requestExecutors, requestBody);
    }

    private static void executeAll(Map<Object, Method> requestExecutors, String requestBody) throws Throwable {
        try {
            for (Map.Entry<Object, Method> requestExecutorEntry : requestExecutors.entrySet()) {
                Object requestExecutor = requestExecutorEntry.getKey();
                Method method = requestExecutorEntry.getValue();
                Boolean result = (Boolean) method.invoke(requestExecutor, requestBody);
                if (result != null && result.equals(Boolean.FALSE)) {
                    System.out.println("Received negative result. Aborting ...");
                    return ;
                }
            }
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }

    }

    public static Map<Object, Method> groupExecutors(List<Object> requestExecutors, List<?> methodParameterType) {
        Map<Object, Method> instanceToMethod =  new HashMap<>();

        for (Object requestExecutor : requestExecutors) {
            Method[] allMethods = requestExecutor.getClass().getDeclaredMethods();

            for (Method method : allMethods) {
                if (Arrays.asList(method.getParameterTypes()).equals(methodParameterType)) {
                    instanceToMethod.put(requestExecutor, method);
                }
            }

        }

        return instanceToMethod;
    }

}
