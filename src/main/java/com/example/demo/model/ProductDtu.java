package com.example.demo.model;

public class ProductDtu
{
    String name;
    int id;
    String beskrivelse;
    double price;

    public ProductDtu(String name, int id, String beskrivelse, double price)
    {
        this.name = name;
        this.id = id;
        this.beskrivelse = beskrivelse;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getBeskrivelse()
    {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse)
    {
        this.beskrivelse = beskrivelse;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}

