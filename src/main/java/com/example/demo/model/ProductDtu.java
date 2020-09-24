package com.example.demo.model;

public class ProductDtu
{
    int id;
    String name;
    String beskrivelse;
    Long price;

    public ProductDtu( int id,String name, Long price, String beskrivelse)
    {
        this.name = name;
        this.id = id;
        this.beskrivelse = beskrivelse;
        this.price = price;
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

    public Long getPrice()
    {
        return price;
    }

    public void setPrice(Long price)
    {
        this.price = price;
    }
}

