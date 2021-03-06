package utils;

import com.alibaba.fastjson.JSONObject;
import com.github.easywork.utils.BeanMapper;
import com.google.common.collect.Lists;
import ma.glasnost.orika.BoundMapperFacade;
import model.Human;
import model.Person;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

/**
 * Created by lgs on 16-2-25.
 */
public class TestBeanMapper {

    @Test
    public void testNullMapper() {
        Person person = new Person();
//        BeanMapper.map(person,null);
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
    }

    @Test
    public void testMapper() {
        Person p1 = new Person();
        p1.setFirstName("lgs");
        p1.setLastName("guangsheng");
        Person p3 = new Person();
        p3.setFirstName("lgs");
        p3.setLastName("guangsheng");
        long startB = System.currentTimeMillis();

        for(int i=0;i<10000000;i++){
            Human p2 = new Human();
//            BeanMapper.copy(p1,p2);
            BeanMapper.map(p1,Human.class);

//            BeanUtils.copyProperties(p1,Human.class);
//            BeanMapper.map(p1,p2);

            if (i==0){
                System.out.println(JSONObject.toJSON(p2));
            }
        }
        long endB = System.currentTimeMillis();
        System.out.println(endB - startB);
        BoundMapperFacade<Person,Human> mapper = BeanMapper.getMapperFactory().getMapperFacade(Person.class, Human.class);

        long start = System.currentTimeMillis();
        for (int i=0;i<10000000;i++) {
            Human p2 = new Human();
//            BeanMapper.copy(p1,Human.class);
//            BeanMapper.map(p1,Human.class);
//            BeanMapper.map(p1,p2);
            mapper.map(p1,p2);
            if (i==0){
                System.out.println(JSONObject.toJSON(p2));
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
    @Test
    public void test(){
       BeanMapper.map(null,new Person());

    }

}