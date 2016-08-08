package utils;

import com.alibaba.fastjson.JSONObject;
import com.github.base.utils.BeanMapper;
import com.google.common.collect.Lists;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import model.Human;
import model.Person;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
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
        p1.setPersons(Lists.newArrayList(p3));
        long startB = System.currentTimeMillis();

        for(int i=0;i<1000000;i++){
            Human p2 = new Human();
            BeanUtils.copyProperties(p1,p2);
            if (i==0){
                System.out.println(JSONObject.toJSON(p2));
            }
        }
        long endB = System.currentTimeMillis();
        System.out.println(endB - startB);

        long start = System.currentTimeMillis();
        BoundMapperFacade<Person,Human> mapper = BeanMapper.getMapperFactory().getMapperFacade(Person.class, Human.class);
        for (int i=0;i<1000000;i++) {
            Human p2 = new Human();

            mapper.map(p1,p2);
            if (i==0){
                System.out.println(JSONObject.toJSON(p2));
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

}