package DesignPatterns.Facade.HttpExercise;

import java.io.IOException;


public class Main {


    private static final String GET_URL = "https://reqres.in/api/users/2";

    private static final String GET_URL_NOT_FOUND = "https://reqres.in/api/users/23";
    private static final String POST_URL = "https://reqres.in/api/users";
    private static final String DELETE_URL = "https://reqres.in/api/users/2";
    private static final String PUT_URL = "https://reqres.in/api/users/2";

    public static void main(String[] args) throws IOException {

        HttpFacade httpFacade = new HttpFacade();

        //Get request
        Response getResponse = httpFacade.get(GET_URL);
        System.out.println(getResponse);

        //Get request - not found
        Response getNotFoundResponse = httpFacade.get(GET_URL_NOT_FOUND);
        System.out.println(getNotFoundResponse);

        //Post request
        Response postResponse = httpFacade.post(POST_URL, "Sharon", "Developer");
        System.out.println(postResponse);

        //Delete request
        Response deleteResponse = httpFacade.delete(DELETE_URL);
        System.out.println(deleteResponse);

        //Put request
        Response putResponse = httpFacade.put(PUT_URL, "Sharon", "Chef");
        System.out.println(putResponse);

        //Patch request
        Response patchResponse = httpFacade.patch(PUT_URL, "Sharon", "123");
        System.out.println(patchResponse);
    }
}