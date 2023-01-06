package org.selenium.utils;

import java.io.*;
import java.util.Properties;

public class PropertyUtils {

    public static Properties propertyLoader(String filepath)
    {

        Properties properties= new Properties();
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;

        try{
            bufferedReader= new BufferedReader(new FileReader(filepath));
            fileInputStream=new FileInputStream(filepath);
            try{
                properties.load(bufferedReader);
                properties.load(fileInputStream);
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            throw  new RuntimeException("Property Files not found at"+filepath);
        }

        return properties;
    }
}
