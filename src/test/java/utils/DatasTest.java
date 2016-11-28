package utils;

import com.alibaba.fastjson.JSONObject;
import com.github.easywork.utils.Datas;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import model.Person;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Optional;

/**
 * Created by user on 2016/11/10.
 */
@Slf4j
public class DatasTest {

    @Test
    public void test(){
        Person p = new Person();
        Optional.ofNullable(p.getId()).ifPresent(e->{p.setId(e);});
        Datas.when(true,()->p.setFirstName("lgs"));
       System.out.printf(JSONObject.toJSONString(p));
    }
    @Test
    public void single(){
        Datas.single(null);
        Datas.single(Lists.newLinkedList());
        Datas.single(new LinkedHashSet<>());
        Datas.single(Lists.newArrayList());
        String.format("%%s%","s");
    }
}
