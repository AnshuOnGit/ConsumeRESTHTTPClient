package org.june.learn;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpHost target = new HttpHost("ec2-52-203-235-18.compute-1.amazonaws.com", 80, "http");
        HttpGet getRequest = new HttpGet("/UsersApp/users");
        try {
            HttpResponse httpResponse = httpclient.execute(target, getRequest);
            HttpEntity entity = httpResponse.getEntity();

            System.out.println("----------------------------------------");
            System.out.println(httpResponse.getStatusLine());
            Header[] headers = httpResponse.getAllHeaders();
            for (int i = 0; i < headers.length; i++) {
                System.out.println(headers[i]);
            }
            System.out.println("----------------------------------------");


            String response = EntityUtils.toString(entity);
            if (entity != null) {
               System.out.println(response);
            }


            JSONArray jsonArray =new JSONArray(response);
            System.out.println(jsonArray.get(1));
            for(Object element : jsonArray){
                System.out.println(element);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
