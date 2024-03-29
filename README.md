# app-mkm-rest project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

for win  native
```
"C:\Program Files (x86)\Microsoft Visual Studio\2017\BuildTools\VC\Auxiliary\Build\vcvarsx86_amd64.bat"
mvn package -Pnative -DskipTests
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `app-mkm-rest-1.0.0-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/app-mkm-rest-1.0.0-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/app-mkm-rest-1.0.0-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.


pre req
github.com/grpc-ecosystem/grpc-gateway

```shell script


```
protoc

//-I%GOPATH%\src
protoc -IC:\dev\bin\protoc-3.5.1\include -I.  -I%GOPATH%\src\github.com\grpc-ecosystem\grpc-gateway\third_party\googleapis --go_out=plugins=grpc:. .\my-proto\my-service.proto




mvn -f pomprotogen.xml generate-resources
mvn quarkus:dev