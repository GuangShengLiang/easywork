package utils;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebInterface {

    @GET("account/itn/")
    Call<String> getHomeIndex(@Query("name") String name);
}
