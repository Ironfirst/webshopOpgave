package com.example.demo.model;
// wephook change test
// hulllllllla testetstetste
public class ProductDtu
{
    int id;
    String name;
    Double price;
    String beskrivelse;

    public ProductDtu( int id,String name, Double price, String beskrivelse)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.beskrivelse = beskrivelse;
    }


    // tom constructor til oprettelse af objecter
    public ProductDtu(){

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

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }
}

