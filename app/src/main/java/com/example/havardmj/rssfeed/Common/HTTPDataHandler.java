package com.example.havardmj.rssfeed.Common;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Havardmj on 21-Feb-18.
 */

public class HTTPDataHandler {

    static String stream = null;

    public HTTPDataHandler() {

    }

    public static String getStream() {
        return stream;
    }

    public static void setStream(String stream) {
        HTTPDataHandler.stream = stream;
    }

    public String GetHTTPData(String urlString) {

        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader read = new BufferedReader(new InputStreamReader(in));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while((line = read.readLine()) != null) {
                    stringBuilder.append(line);
                }
                stream = stringBuilder.toString();
                urlConnection.disconnect();

            }

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }

}
