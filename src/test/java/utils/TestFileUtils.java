package utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import model.Blocked;
import model.Nav;
import okhttp3.OkHttpClient;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;
import java.util.Map;

@Slf4j
public class TestFileUtils {
    RestTemplate restTemplate = new RestTemplate();
    @Test
    public void testFile(){
        String url = "jdbc:mysql://localhost:3306/vip?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
        String uname = "root";
        String password = "";
        try {
            Connection conn = null;
            PreparedStatement pstmt = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,uname ,password);
            String sql = "SELECT mid FROM blocked_temp";
            QueryRunner queryRunner = new QueryRunner();
            List<Blocked> result = queryRunner.query(conn,sql, new BeanListHandler<Blocked>(Blocked.class));

//            List<String> lines = Files.readAllLines(Paths.get("/Users/user/downloads/blocked_temp"), StandardCharsets.UTF_8);
            List<String> sqls = Lists.newLinkedList();
            result.forEach(e->sqls.add(String.format("INSERT INTO blocked_temp(mid,status) VALUES (%d,0);",e.getMid())));
            Files.write(Paths.get("/Users/user/downloads/blocked_temp.sql"),sqls, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUp(){
        String navurl = "http://space.bilibili.com";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(navurl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
        SpaceApi spaceApi = retrofit.create(SpaceApi.class);

        String url = "jdbc:mysql://localhost:3306/vip?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
        String uname = "root";
        String password = "";
        List<String> sqls = Lists.newLinkedList();
        try {
            Connection conn = null;
            PreparedStatement pstmt = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,uname ,password);
            String sql = "SELECT mid FROM blocked_temp";
            QueryRunner queryRunner = new QueryRunner();
            List<Blocked> result = queryRunner.query(conn,sql, new BeanListHandler<Blocked>(Blocked.class));
            for (Blocked b:result){
//                Nav n = restTemplate.getForObject(String.format(navurl,b.getMid()), Nav.class);
                Response<Nav> n = spaceApi.getNavNum(b.getMid()).execute();
                if (n.body().getData().getVideo()>0){
                    sqls.add(String.format("INSERT INTO blocked_temp2(mid,status) VALUES (%d,0);",b.getMid()));
                }
            }
            Files.write(Paths.get("/Users/user/downloads/blocked_temp2.sql"),sqls, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void a(){

    }

}
