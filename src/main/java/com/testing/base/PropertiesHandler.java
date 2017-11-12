/*
 * Created by Costea Mihai Alexandru on 11/12/17 6:51 PM
 * Copyright (c) 2017.
 * All rights reserved.
 *
 * Last modified 11/12/17 6:51 PM
 */

package com.testing.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesHandler {
    private InputStream inputStream;
    private Properties properties = new Properties();
    private static PropertiesHandler instance = null;

    private PropertiesHandler(){

        try{
            String propertiesFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

            if(inputStream != null){
                properties.load(inputStream);
            }else{
                throw new FileNotFoundException("properties file " + propertiesFileName + "not found in classpath");
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static synchronized PropertiesHandler getInstance(){
        if(instance == null){
            instance = new PropertiesHandler();
        }
        return instance;
    }

    public String getValue(String propertyKey){
        return this.properties.getProperty(propertyKey);
    }

}
