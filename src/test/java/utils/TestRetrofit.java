package utils;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TestRetrofit {
    private final static WebInterface webInterface;
    static {
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(500L, TimeUnit.MILLISECONDS)
                .writeTimeout(500L,TimeUnit.MILLISECONDS)
                .connectTimeout(500L,TimeUnit.MILLISECONDS).addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        HttpUrl url =chain.request().url();
                        String query = chain.request().url().encodedQuery();
//                        String path = chain.request().url().encodedPath();
//                        String path = chain.request().url().uri().
                        long t2 = System.currentTimeMillis();
                        Response resp = chain.proceed(chain.request());
                        long t1 = System.currentTimeMillis();
                        log.info("|{}|req {}|res {}|{}",query,resp.toString());
                        System.out.println(String.format("|%s|req %s|res %s|%d",url,query,resp.toString(),t1-t2));
                        return resp;
                    }
                }).build();
        webInterface = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .client(client)//这个client是OkHttpClient，以后和Okhttp的基本用法和流程分析中细说
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(new ToStringConverterFactory())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build()
                .create(WebInterface.class);
    }
    @Test
    public void testAsyn(){
        Call<String> rst = webInterface.getHomeIndex("test");
        rst.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                System.out.println(response);
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                System.out.println(throwable);
            }
        });
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void TestB(){
        Call<String> rst = webInterface.getHomeIndex("test");
        try {
            String r =rst.execute().body();
            System.out.println(r);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

