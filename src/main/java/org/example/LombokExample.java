package org.example;

public class LombokExample

{

    public static void main(String[] args) {
        LambokImpl lambok= LambokImpl.builder().age(20).gender('M').name("Kameswara").rollno(205).build();
        System.out.println(lambok.getAge());
    }
}
