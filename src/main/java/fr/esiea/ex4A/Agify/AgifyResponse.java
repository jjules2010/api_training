package fr.esiea.ex4A.Agify;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AgifyResponse{

    public final String name;
    public final int age;
    public final int count;
    public final String country;

    
    public AgifyResponse(@JsonProperty(value = "name", required = true) String name,@JsonProperty("age") int age,@JsonProperty("count") int count,@JsonProperty("country_id") String country){
        this.name = name;
        this.age = age;
        this.count = count;
        this.country = country;
    }
    
}
