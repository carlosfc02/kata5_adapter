package software.ulpgc.kata5_adapter;

import spark.Response;

public class SparkResponseAdapter implements Output{
    private final Response response;
    private String body;

    public SparkResponseAdapter(Response response) {
        this.response = response;
    }

    @Override
    public void setStatus(int status) {
        response.status(status);
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String getBody() {
        return body;
    }
}
