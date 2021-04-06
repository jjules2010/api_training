package fr.esiea.ex4A.agify;

import fr.esiea.ex4A.models.AgifyResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AgifyClient {
    @GET("/")
    Call<AgifyResponse> getAge(@Query("name") String userName, @Query("country_id") String country);
}
