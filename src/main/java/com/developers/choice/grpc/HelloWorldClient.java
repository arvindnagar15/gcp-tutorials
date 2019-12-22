package com.developers.choice.grpc;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HelloWorldClient {

	private MyGrpcServiceGrpc.MyGrpcServiceBlockingStub stub = null;

    @PostConstruct
    public void init(){
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565)
                                        .usePlaintext().build();
        stub = MyGrpcServiceGrpc.newBlockingStub(managedChannel);
    }

    public HelloReply getNameData(String name){
        HelloRequest request = HelloRequest
                                .newBuilder()
                                .setName(name)
                                .build();
        HelloReply reply = stub.sayHello(request);

        System.out.println(reply);

        return reply;
    }

}
