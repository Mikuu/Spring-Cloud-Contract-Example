Spring Cloud Contract Example
--

## Provider Side test

### run tests to generate Unit Tests and Stubs.
```commandline
./gradlew :example-provider:test
```

### publish Stubs to local maven repository e.g. .m2 repository.
```commandline
./gradlew :example-provider:publishStubsPublicationToMavenLocal
```

## Consumer Side tests

### run consumer miku's integration tests
```commandline
./gradlew :example-consumer-miku:test
```

### run consumer nanoha's integration tests
```commandline
./gradlew :example-consumer-nanoha:test
```