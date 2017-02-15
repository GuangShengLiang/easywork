package utils;

import com.github.easywork.json.JsonResponse;
import model.Person;
import org.junit.Test;

/**
 * Created by user on 2016/11/2.
 */
public class TestJsonResponse {
    @Test
    public void test1(){
        JsonResponse<Person> response1 = JsonResponse.fail(null);
        Person p1 = response1.getData();
        JsonResponse<Person> response2 = JsonResponse.success(new Person());
        Person p2 = response2.getData();
        JsonResponse<Person> response3 = JsonResponse.success();
        Person p3 = response3.getData();
        JsonResponse<Person> response4 = JsonResponse.success(null);
        Person p4 = response4.getData();
        JsonResponse<Person> response5 = JsonResponse.fail("test");
        Person p5 = response5.getData();
        JsonResponse response6 = JsonResponse.fail("test2");
        response6.getData();
    }
}
