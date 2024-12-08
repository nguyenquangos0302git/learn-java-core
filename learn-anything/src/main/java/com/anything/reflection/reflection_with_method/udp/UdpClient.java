package com.anything.reflection.reflection_with_method.udp;

public class UdpClient {
    public void sendAndForget(String requestPayload) {
        System.out.println(String.format("Request : %s was sent through UDP", requestPayload));
    }
}
