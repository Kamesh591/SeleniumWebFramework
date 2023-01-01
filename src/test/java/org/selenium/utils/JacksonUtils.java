package org.selenium.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.selenium.dataobjects.BillingAddress;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {

    public static BillingAddress deSerializeJSON(InputStream is,BillingAddress billingAddress) throws IOException {
        ObjectMapper objectMapper= new ObjectMapper();
       return objectMapper.readValue(is,billingAddress.getClass());
    }

    /*
    Purpose Genericway of reading the JSON objects
     */

    public static <T> T deSerializeJSON(String fileName,Class<T> T) throws IOException {
        InputStream inputStream=JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
        ObjectMapper objectMapper= new ObjectMapper();
        return objectMapper.readValue(inputStream,T);
    }
}
