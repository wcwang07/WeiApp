package com.pluto.wservice.model;

import java.util.List;

public class WebPayload //implements Serializable
{

    private String name;

    private List<Integer> cars;

    private Integer age;

    public WebPayload(){
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }
    public void setAge(Integer age)
    {
        this.age = age;
    }
    public void setCars(List<Integer> cars){
        this.cars = cars;
    }
    public List<Integer> getCars(){
        return cars;
    }
}

