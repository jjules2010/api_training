package fr.esiea.ex4A.Agify;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AgifyClient {

    @GET("/")
    public Call<AgifyResponse> getAge(@Query("name") String userName, @Query("country_id") String country);
}
