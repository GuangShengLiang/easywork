package utils;

import com.github.easywork.json.JsonPageResponse;
import com.google.common.collect.Lists;
import model.Person;
import org.junit.Test;

import java.util.List;

/**
 * Created by user on 2016/11/2.
 */
public class TestJsonPageResponse {

    @Test
    public void test1(){
        JsonPageResponse<Person> response1 = JsonPageResponse.fail("test");
        List<Person> p1 = response1.getData();
        List<Person> persons = Lists.newLinkedList();
        persons.add(new Person());
        JsonPageResponse<Person> response2 = JsonPageResponse.success(persons,1);
        List<Person> p2 = response2.getData();
        JsonPageResponse<Person> response3 = JsonPageResponse.success(null,0);
        List<Person> p3 = response3.getData();

    }
}
