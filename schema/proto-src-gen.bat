

:: onetme execution
:: cd %GOPATH%\src
:: git clone https://github.com/grpc-ecosystem/grpc-gateway.git
:: go get github.com/grpc-ecosystem/grpc-gateway/..

set PROJ_DIR=C:\data\proj-mkm\app-mkm-rest
set INPUT_DIR=%PROJ_DIR%\schema\proto
set SRCGEN_DIR=%PROJ_DIR%\src\zgen\proto\java
set PROTOC_HOME=C:\apps\google\protoc-3.13.0
set PROTOC_BIN=%PROTOC_HOME%\bin\protoc.exe
set PROTOC_INCLUDE=%PROTOC_HOME%\include
:: set PROTOC_JAVA_BIN=C:\apps\google\protoc-3.13.0\bin\protoc-gen-grpc-java-1.32.1.exe
%PROTOC_BIN% -I%PROTOC_INCLUDE%\ -I%GOPATH%\src\github.com\grpc-ecosystem\grpc-gateway\third_party\googleapis --proto_path=%INPUT_DIR% --java_out=%SRCGEN_DIR% muni-model.proto muni-service.proto
echo off
echo !!!!!!!!!!!!!!!!!!!!!!!!! DO NOT FORGET !!!!!!!!!!!!!!!!!!!!!!!!!!
echo !!                                                              !!
echo !!  Add @JsonSerialize(using = SerializerGeneric.class)         !!
echo !!      @JsonDeserialize(using = DeserializeSearchRequest.class)!!
echo !!      public  static final class SearchRequest extends        !!
echo !!                                                              !!
echo !!!!!!!!!!!!!!!!! Add Json annotation to api objects     !!!!!!!!!
pause