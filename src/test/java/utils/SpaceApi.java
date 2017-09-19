package utils;

import model.Nav;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpaceApi {

    @GET("/ajax/member/getNavNum")
    Call<Nav> getNavNum(@Query("mid") int mid);
}
