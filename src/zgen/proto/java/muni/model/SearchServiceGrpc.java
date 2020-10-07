package muni.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: muni-service.proto")
public final class SearchServiceGrpc {

  private SearchServiceGrpc() {}

  public static final String SERVICE_NAME = "muni.model.SearchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<muni.model.MuniService.SearchPersonReq,
      muni.model.MuniService.SearchPersonRes> getPersonByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "personById",
      requestType = muni.model.MuniService.SearchPersonReq.class,
      responseType = muni.model.MuniService.SearchPersonRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<muni.model.MuniService.SearchPersonReq,
      muni.model.MuniService.SearchPersonRes> getPersonByIdMethod() {
    io.grpc.MethodDescriptor<muni.model.MuniService.SearchPersonReq, muni.model.MuniService.SearchPersonRes> getPersonByIdMethod;
    if ((getPersonByIdMethod = SearchServiceGrpc.getPersonByIdMethod) == null) {
      synchronized (SearchServiceGrpc.class) {
        if ((getPersonByIdMethod = SearchServiceGrpc.getPersonByIdMethod) == null) {
          SearchServiceGrpc.getPersonByIdMethod = getPersonByIdMethod =
              io.grpc.MethodDescriptor.<muni.model.MuniService.SearchPersonReq, muni.model.MuniService.SearchPersonRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "personById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  muni.model.MuniService.SearchPersonReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  muni.model.MuniService.SearchPersonRes.getDefaultInstance()))
              .setSchemaDescriptor(new SearchServiceMethodDescriptorSupplier("personById"))
              .build();
        }
      }
    }
    return getPersonByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<muni.model.MuniService.SearchPersonReq,
      muni.model.MuniService.SearchPersonRes> getPersonsSimilarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "personsSimilar",
      requestType = muni.model.MuniService.SearchPersonReq.class,
      responseType = muni.model.MuniService.SearchPersonRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<muni.model.MuniService.SearchPersonReq,
      muni.model.MuniService.SearchPersonRes> getPersonsSimilarMethod() {
    io.grpc.MethodDescriptor<muni.model.MuniService.SearchPersonReq, muni.model.MuniService.SearchPersonRes> getPersonsSimilarMethod;
    if ((getPersonsSimilarMethod = SearchServiceGrpc.getPersonsSimilarMethod) == null) {
      synchronized (SearchServiceGrpc.class) {
        if ((getPersonsSimilarMethod = SearchServiceGrpc.getPersonsSimilarMethod) == null) {
          SearchServiceGrpc.getPersonsSimilarMethod = getPersonsSimilarMethod =
              io.grpc.MethodDescriptor.<muni.model.MuniService.SearchPersonReq, muni.model.MuniService.SearchPersonRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "personsSimilar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  muni.model.MuniService.SearchPersonReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  muni.model.MuniService.SearchPersonRes.getDefaultInstance()))
              .setSchemaDescriptor(new SearchServiceMethodDescriptorSupplier("personsSimilar"))
              .build();
        }
      }
    }
    return getPersonsSimilarMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      muni.model.MuniService.SearchPersonRes> getPersonsAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "personsAll",
      requestType = com.google.protobuf.Empty.class,
      responseType = muni.model.MuniService.SearchPersonRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      muni.model.MuniService.SearchPersonRes> getPersonsAllMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, muni.model.MuniService.SearchPersonRes> getPersonsAllMethod;
    if ((getPersonsAllMethod = SearchServiceGrpc.getPersonsAllMethod) == null) {
      synchronized (SearchServiceGrpc.class) {
        if ((getPersonsAllMethod = SearchServiceGrpc.getPersonsAllMethod) == null) {
          SearchServiceGrpc.getPersonsAllMethod = getPersonsAllMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, muni.model.MuniService.SearchPersonRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "personsAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  muni.model.MuniService.SearchPersonRes.getDefaultInstance()))
              .setSchemaDescriptor(new SearchServiceMethodDescriptorSupplier("personsAll"))
              .build();
        }
      }
    }
    return getPersonsAllMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SearchServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SearchServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SearchServiceStub>() {
        @java.lang.Override
        public SearchServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SearchServiceStub(channel, callOptions);
        }
      };
    return SearchServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SearchServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SearchServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SearchServiceBlockingStub>() {
        @java.lang.Override
        public SearchServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SearchServiceBlockingStub(channel, callOptions);
        }
      };
    return SearchServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SearchServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SearchServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SearchServiceFutureStub>() {
        @java.lang.Override
        public SearchServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SearchServiceFutureStub(channel, callOptions);
        }
      };
    return SearchServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SearchServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Returns a specific Person
     * Client example - returns person id=1:
     *   curl http://localhost:8080/mkapp/v1/person/1
     * </pre>
     */
    public void personById(muni.model.MuniService.SearchPersonReq request,
        io.grpc.stub.StreamObserver<muni.model.MuniService.SearchPersonRes> responseObserver) {
      asyncUnimplementedUnaryCall(getPersonByIdMethod(), responseObserver);
    }

    /**
     * <pre>
     *     option (google.api.http) = {
     *       post: "/mkapp/v1/persons/similar"
     *       body: "person"
     *     };
     * </pre>
     */
    public void personsSimilar(muni.model.MuniService.SearchPersonReq request,
        io.grpc.stub.StreamObserver<muni.model.MuniService.SearchPersonRes> responseObserver) {
      asyncUnimplementedUnaryCall(getPersonsSimilarMethod(), responseObserver);
    }

    /**
     * <pre>
     *google.protobuf.Empty
     * </pre>
     */
    public void personsAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<muni.model.MuniService.SearchPersonRes> responseObserver) {
      asyncUnimplementedUnaryCall(getPersonsAllMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPersonByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                muni.model.MuniService.SearchPersonReq,
                muni.model.MuniService.SearchPersonRes>(
                  this, METHODID_PERSON_BY_ID)))
          .addMethod(
            getPersonsSimilarMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                muni.model.MuniService.SearchPersonReq,
                muni.model.MuniService.SearchPersonRes>(
                  this, METHODID_PERSONS_SIMILAR)))
          .addMethod(
            getPersonsAllMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                muni.model.MuniService.SearchPersonRes>(
                  this, METHODID_PERSONS_ALL)))
          .build();
    }
  }

  /**
   */
  public static final class SearchServiceStub extends io.grpc.stub.AbstractAsyncStub<SearchServiceStub> {
    private SearchServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SearchServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a specific Person
     * Client example - returns person id=1:
     *   curl http://localhost:8080/mkapp/v1/person/1
     * </pre>
     */
    public void personById(muni.model.MuniService.SearchPersonReq request,
        io.grpc.stub.StreamObserver<muni.model.MuniService.SearchPersonRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPersonByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *     option (google.api.http) = {
     *       post: "/mkapp/v1/persons/similar"
     *       body: "person"
     *     };
     * </pre>
     */
    public void personsSimilar(muni.model.MuniService.SearchPersonReq request,
        io.grpc.stub.StreamObserver<muni.model.MuniService.SearchPersonRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPersonsSimilarMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *google.protobuf.Empty
     * </pre>
     */
    public void personsAll(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<muni.model.MuniService.SearchPersonRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPersonsAllMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SearchServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SearchServiceBlockingStub> {
    private SearchServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SearchServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a specific Person
     * Client example - returns person id=1:
     *   curl http://localhost:8080/mkapp/v1/person/1
     * </pre>
     */
    public muni.model.MuniService.SearchPersonRes personById(muni.model.MuniService.SearchPersonReq request) {
      return blockingUnaryCall(
          getChannel(), getPersonByIdMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *     option (google.api.http) = {
     *       post: "/mkapp/v1/persons/similar"
     *       body: "person"
     *     };
     * </pre>
     */
    public muni.model.MuniService.SearchPersonRes personsSimilar(muni.model.MuniService.SearchPersonReq request) {
      return blockingUnaryCall(
          getChannel(), getPersonsSimilarMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *google.protobuf.Empty
     * </pre>
     */
    public muni.model.MuniService.SearchPersonRes personsAll(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getPersonsAllMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SearchServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SearchServiceFutureStub> {
    private SearchServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SearchServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a specific Person
     * Client example - returns person id=1:
     *   curl http://localhost:8080/mkapp/v1/person/1
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<muni.model.MuniService.SearchPersonRes> personById(
        muni.model.MuniService.SearchPersonReq request) {
      return futureUnaryCall(
          getChannel().newCall(getPersonByIdMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *     option (google.api.http) = {
     *       post: "/mkapp/v1/persons/similar"
     *       body: "person"
     *     };
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<muni.model.MuniService.SearchPersonRes> personsSimilar(
        muni.model.MuniService.SearchPersonReq request) {
      return futureUnaryCall(
          getChannel().newCall(getPersonsSimilarMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *google.protobuf.Empty
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<muni.model.MuniService.SearchPersonRes> personsAll(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getPersonsAllMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PERSON_BY_ID = 0;
  private static final int METHODID_PERSONS_SIMILAR = 1;
  private static final int METHODID_PERSONS_ALL = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SearchServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SearchServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PERSON_BY_ID:
          serviceImpl.personById((muni.model.MuniService.SearchPersonReq) request,
              (io.grpc.stub.StreamObserver<muni.model.MuniService.SearchPersonRes>) responseObserver);
          break;
        case METHODID_PERSONS_SIMILAR:
          serviceImpl.personsSimilar((muni.model.MuniService.SearchPersonReq) request,
              (io.grpc.stub.StreamObserver<muni.model.MuniService.SearchPersonRes>) responseObserver);
          break;
        case METHODID_PERSONS_ALL:
          serviceImpl.personsAll((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<muni.model.MuniService.SearchPersonRes>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SearchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return muni.model.MuniService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SearchService");
    }
  }

  private static final class SearchServiceFileDescriptorSupplier
      extends SearchServiceBaseDescriptorSupplier {
    SearchServiceFileDescriptorSupplier() {}
  }

  private static final class SearchServiceMethodDescriptorSupplier
      extends SearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SearchServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SearchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SearchServiceFileDescriptorSupplier())
              .addMethod(getPersonByIdMethod())
              .addMethod(getPersonsSimilarMethod())
              .addMethod(getPersonsAllMethod())
              .build();
        }
      }
    }
    return result;
  }
}
