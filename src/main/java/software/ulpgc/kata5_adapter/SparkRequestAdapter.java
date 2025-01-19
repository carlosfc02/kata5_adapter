package software.ulpgc.kata5_adapter;

import spark.Request;

public class SparkRequestAdapter implements Input{
    private final Request request;

    public SparkRequestAdapter(Request request) {
        this.request = request;
    }


    @Override
    public String getParameter(String name) {
        return request.params(name) != null ? request.params(name) : request.queryParams(name);
    }
}
