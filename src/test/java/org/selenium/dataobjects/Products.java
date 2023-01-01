package org.selenium.dataobjects;

import org.selenium.utils.JacksonUtils;

import java.io.IOException;

public class Products {


    public Products(){

    }

    public Products(int id) throws IOException {
        Products[] products=JacksonUtils.deSerializeJSON("products.json",Products[].class);
        for (Products products1:products){
            if (products1.getId()==id){
                this.id=products1.getId();
                this.name=products1.getName();
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private String name;

}
