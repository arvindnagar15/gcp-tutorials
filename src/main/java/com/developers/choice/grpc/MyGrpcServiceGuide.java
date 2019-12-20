//package com.developers.choice.grpc;
//import com.developers.choice.grpc.*;
//
//import io.grpc.stub.StreamObserver;
//
//public class MyGrpcServiceGuide extends MyGrpcServiceGrpc.MyGrpcServiceImplBase{//.OreDemandImplBase{
//
//    public void sayHello(HelloRequest request,  StreamObserver<HelloReply> responseObserver){
//        HelloReply reply = null;
//        try{
//            reply = getName(request);
//            responseObserver.onNext(reply);
//            responseObserver.onCompleted();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//    }
//    private HelloReply getName(HelloRequest request){
//        String s =  "Hello!!! The name you entered is : "+request.getName();
//        return HelloReply.newBuilder().setMessage(s).build();
//    }
//}
