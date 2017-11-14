/*
 * Created by Costea Mihai Alexandru on 11/11/17 4:06 PM
 * Copyright (c) 2017.
 * All rights reserved.
 *
 * Last modified 11/5/17 9:11 PM
 */

package com.testing.base;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HttpRequestExecutor {

    /**
     * This method will send an xml to the webservice and return the response body that will
     * also be in xml form
     * @param xmlRequestFile provided by the TestCase object
     * @return String the webservice xml response
     */
    public static String invokeWebService(File xmlRequestFile, String webServiceURL){


        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(PropertiesHandler.getInstance().getValue("url"));
        HttpResponse response;
        String responseBody = null;

        try {
            InputStreamEntity streamEntity = new InputStreamEntity(new FileInputStream(xmlRequestFile));
            streamEntity.setContentType("application/xml");
            streamEntity.setChunked(true);
            httpPost.setHeader("Content-type", "text/xml; charset=UTF-8");
            httpPost.setHeader("SOAPAction", "");
            httpPost.setEntity(streamEntity);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {

            response = client.execute(httpPost);
            responseBody = EntityUtils.toString(response.getEntity());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseBody;
    }
}
