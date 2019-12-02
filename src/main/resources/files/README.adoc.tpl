= Enterprise Java application

This application has been generated by the Enterprise Java starter.

The application can be build to a container image, using the following Maven and Docker commands:

----
mvn clean package
docker build -t [# th:utext="${maven_artifactid}"/] .
----

You can start a container of the created image as follows:

----
docker run --rm -p [# th:text="${jk_server_http_port}"/]:[# th:text="${jk_server_http_port}"/] [# th:utext="${maven_artifactid}"/]
----

[# th:if="${jk_servername} == 'liberty'"]
== Liberty Dev Mode

During development, you can use Liberty's development mode (dev mode) to code while observing and testing your changes on the fly.
With the dev mode, you can code along and watch the change reflected in the running server right away.
Unit and integration tests are run on pressing Enter in the command terminal; you can attach a debugger to the running server at any time to step through your code.

You start the development mode as follows:

----
mvn liberty:dev
----
[/]

Once your application is running, either via Docker container or development mode, open your browser at the following URL:

http://localhost:[# th:text="${jk_server_http_port}"/]/index.html

[# th:if="${examples_tests}"]
== Testing

An example of code-level and end-to-end integration tests is included.

The code-level tests (Maven convention `*Test`) are automatically executed on a Maven build.

In order to invoke the integration tests, issue the following Maven command, after your application has been started:

----
mvn test-compile failsafe:integration-test failsafe:verify
----

[/]

== Specification examples

By default, there is always the creation of a JAX-RS application class to define the path on which the JAX-RS endpoints are available.

Also, a simple Hello world endpoint is created, have a look at the class **HelloController**.

More information on MicroProfile can be found [here](https://microprofile.io/)

[# th:if="${examples_mp_config}"]
=== Config

Configuration of your application parameters. Specification https://microprofile.io/project/eclipse/microprofile-config[here^].

The example class `ConfigTestController` shows you how to inject a configuration parameter and how to retrieve it programmatically.
[/]

// TODO add remaining examples
