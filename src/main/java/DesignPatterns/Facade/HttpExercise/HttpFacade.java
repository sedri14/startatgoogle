package DesignPatterns.Facade.HttpExercise;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class HttpFacade {

    private static final String USER_AGENT = "Mozilla/5.0";
    //private CloseableHttpClient httpClient = HttpClients.createDefault();

    public HttpFacade() {

    }

    public Response get(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("User-Agent", USER_AGENT);
        return responseFromHttp(httpGet);
    }

    public Response post(String url, String name, String job) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("User-Agent", USER_AGENT);
        httpPost.addHeader("token", "14587889");
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("name", name));
        urlParameters.add(new BasicNameValuePair("job", job));
        HttpEntity postParams = new UrlEncodedFormEntity(urlParameters);
        httpPost.setEntity(postParams);

        return responseFromHttp(httpPost);
    }

    public Response delete(String url) {
        HttpDelete httpDelete = new HttpDelete(url);
        return responseFromHttp(httpDelete);
    }
    public Response put(String url, String name, String job) throws UnsupportedEncodingException {
        HttpPut httpPut = new HttpPut(url);
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("name", name));
        urlParameters.add(new BasicNameValuePair("job", job));
        HttpEntity postParams = new UrlEncodedFormEntity(urlParameters);
        httpPut.setEntity(postParams);

        return responseFromHttp(httpPut);
    }

    public Response patch(String url, String name, String password) throws UnsupportedEncodingException {
        HttpPatch httpPatch = new HttpPatch(url);
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("name", name));
        urlParameters.add(new BasicNameValuePair("password", password));
        HttpEntity postParams = new UrlEncodedFormEntity(urlParameters);
        httpPatch.setEntity(postParams);

        return responseFromHttp(httpPatch);
    }

    private static Response responseFromHttp (HttpRequestBase request){
        int statusCode = 0;
        String responseBody = null;

        CloseableHttpClient httpClient = HttpClients.createDefault();
        try (CloseableHttpResponse httpResponse = httpClient.execute(request)) {

            statusCode = httpResponse.getStatusLine().getStatusCode();
            System.out.println(request.getClass().getSimpleName() + "Response Status:: " + statusCode);

            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                responseBody = EntityUtils.toString(entity);
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(responseBody==null){
            return new Response(statusCode);
        }
        return new Response(statusCode, responseBody);
    }
}
