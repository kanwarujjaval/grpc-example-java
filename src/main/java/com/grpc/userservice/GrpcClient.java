package com.grpc.userservice;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        System.out.println(channel);

        UserServiceGrpc.UserServiceBlockingStub stub
                = UserServiceGrpc.newBlockingStub(channel);

        UserResponse helloResponse = stub.hello(UserRequest.newBuilder()
                .setFirstName("fname")
                .setLastName("lname")
                .build());

        System.out.println("client");
        System.out.println(helloResponse);

        channel.shutdown();
    }
}
