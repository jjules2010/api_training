package fr.esiea.ex4A.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AgifyResponse{

    private final String name;
    private final int age;
    private final int count;
    private final String country;

    public AgifyResponse(@JsonProperty(value = "name", required = true) String name, @JsonProperty(value = "age", required = true) int age, @JsonProperty("count") int count, @JsonProperty(value = "country_id", required = true) String country){
        this.name = name;
        this.age = age;
        this.count = count;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCount() {
        return count;
    }

    public String getCountry() {
        return country;
    }
}
