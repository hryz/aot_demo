# GraalVM AOT + DDB Client + Kotlin

- [GraalVM](https://www.graalvm.org) allows compiling JVM code to native code (like Go/Rust).  
  This can be quite handy for reducing the cold start time of AWS Lambdas.  
- The most convinient way of compiling your java code natively is Gradle Plugin.  
- DynamoDB Enhanced Client uses reflection and can't be nitively compiled without extra configuration.

## Cold start difference
Running the main method (and accessing [DDB Local](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html)) on a M1Pro MacBook Pro:
- JIT: 1180 ms (+CPU was pretty busy)
- AOT: 20 ms (CPU was idling)
```sh
time bin/app
```
> bin/app  1.18s user 0.07s system 202% cpu 0.616 total
```sh
time nativeCompile/app
```
> nativeCompile/app  0.02s user 0.01s system 32% cpu 0.071 total
