package utils;

import com.github.base.utils.BeanMapper;
import model.Person;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by lgs on 16-2-25.
 */
public class TestBeanMapper {

    @Test
    public void testNullMapper(){
        Person person = new Person();
//        BeanMapper.map(person,null);
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }
}
