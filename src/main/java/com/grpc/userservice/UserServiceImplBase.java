package com.grpc.userservice;

import io.grpc.stub.StreamObserver;

public class UserServiceImplBase extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void hello(UserRequest request, StreamObserver<UserResponse> responseObserver) {

        String greeting = new StringBuilder()
                .append("Hello asd, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        UserResponse response = UserResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        System.out.println("request");
        System.out.println(request);

        System.out.println("response");
        System.out.println(response);

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
