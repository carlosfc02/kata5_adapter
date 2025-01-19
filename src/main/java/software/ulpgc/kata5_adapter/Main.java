package software.ulpgc.kata5_adapter;

import spark.Spark;

public class Main {
    public static void main(String[] args) {
        Spark.port(8081);

        Spark.get("/factorial/:number", (request, response) -> {
            Input input = new SparkRequestAdapter(request);
            Output output = new SparkResponseAdapter(response);
            new Factorial().handle(input, output);
            return output.getBody();
        });

        Spark.get("/fibonacci/:number", (request, response) -> {
            Input input = new SparkRequestAdapter(request);
            Output output = new SparkResponseAdapter(response);
            new Fibonacci().handle(input, output);
            return output.getBody();
        });
    }
}