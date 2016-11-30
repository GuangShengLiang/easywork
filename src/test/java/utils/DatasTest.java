package utils;

import com.alibaba.fastjson.JSONObject;
import com.github.easywork.utils.Datas;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import model.Person;
import org.junit.Assert;
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
//        String.format("%%s%","s");
    }

    @Test
    public void auth(){
//        只读
        Assert.assertEquals(1%1 == 0,true);
        Assert.assertEquals(1%2 == 0,false);
        Assert.assertEquals(1%3 == 0,false);
        Assert.assertEquals(1%5 == 0,false);
//创建
        Assert.assertEquals(2%1 == 0,true);
        Assert.assertEquals(2%2 == 0,true);
        Assert.assertEquals(2%3 == 0,false);
        Assert.assertEquals(2%5 == 0,false);
//只改
        Assert.assertEquals(3%1 == 0,true);
        Assert.assertEquals(3%2 == 0,false);
        Assert.assertEquals(3%3 == 0,true);
        Assert.assertEquals(3%5 == 0,false);
//只删

        Assert.assertEquals(5%1 == 0,true);
        Assert.assertEquals(5%2 == 0,false);
        Assert.assertEquals(5%3 == 0,false);
        Assert.assertEquals(5%5 == 0,true);

        //创建修改

        Assert.assertEquals(6%1 == 0,true);
        Assert.assertEquals(6%2 == 0,true);
        Assert.assertEquals(6%3 == 0,true);
        Assert.assertEquals(6%5 == 0,false);

        //创建删除

        Assert.assertEquals(10%1 == 0,true);
        Assert.assertEquals(10%2 == 0,true);
        Assert.assertEquals(10%3 == 0,false);
        Assert.assertEquals(10%5 == 0,true);

        //修改删除

        Assert.assertEquals(15%1 == 0,true);
        Assert.assertEquals(15%2 == 0,false);
        Assert.assertEquals(15%3 == 0,true);
        Assert.assertEquals(15%5 == 0,true);

        //全部

        Assert.assertEquals(0%1 == 0,true);
        Assert.assertEquals(0%2 == 0,true);
        Assert.assertEquals(0%3 == 0,true);
        Assert.assertEquals(0%5 == 0,true);
    }
}
