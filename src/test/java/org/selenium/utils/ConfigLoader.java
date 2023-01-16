package org.selenium.utils;

import com.google.common.base.Strings;
import io.netty.util.internal.StringUtil;
import org.selenium.consts.EnvType;

import java.util.Properties;

public class ConfigLoader {


    private static ConfigLoader configLoader;
    private static Properties propertyUtils;

    private ConfigLoader(){
        String env= System.getProperty("env", String.valueOf(EnvType.STAGE));
        switch (EnvType.valueOf(env)){
            case STAGE:
                propertyUtils= PropertyUtils.propertyLoader("src/test/resources/stg_config.properties");
                break;

            case QA:
                propertyUtils= PropertyUtils.propertyLoader("src/test/resources/qa_config.properties");
                break;

            case PRODUCTION:
                propertyUtils=PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
                break;

            default:
                throw new RuntimeException("Right Environment is not selected");
        }




    }

    public static ConfigLoader getInstance(){

        if (configLoader==null){
            configLoader= new ConfigLoader();
        }
            return configLoader;
    }

    /*public String baseURI(String url){
       return propertyUtils.getProperty(url);
    }

    public String username(String key){
        return propertyUtils.getProperty(key);
    }*/

    public String getValue(String key){
        String value=propertyUtils.getProperty(key);
        if (Strings.isNullOrEmpty(value)){
            throw new RuntimeException(key+"\t is not available in the provided file");
        }
        return value;
    }




}
