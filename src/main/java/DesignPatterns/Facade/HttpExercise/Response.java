package DesignPatterns.Facade.HttpExercise;

public class Response {

    private int statusCode;
    private String body;

    public Response(int statusCode) {
        this.statusCode = statusCode;
    }

    public Response(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }


    @Override
    public String toString() {
        return "Response{" +
                "statusCode=" + statusCode +
                ", body='" + body + '\'' +
                '}';
    }
}
