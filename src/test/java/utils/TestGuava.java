package utils;

import com.alibaba.fastjson.JSONObject;
import com.github.easywork.json.JsonPageResponse;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import model.Person;
import org.junit.Test;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;

/**
 * @Author lgs
 * @Date 15-12-7 上午11:10
 */
public class TestGuava {
    @Test
    public void testList() {
        List list = Lists.newArrayList("a");
        Joiner joiner = Joiner.on(",");
        joiner.join("a", "b", "c");
    }

    @Test
    public void testOrdering() {
        Comparator<Person> byLastName = new Comparator<Person>() {
            public int compare(final Person p1, final Person p2) {

                return p1.getLastName().compareTo(p2.getLastName());
            }
        };


        Comparator<Person> byFirstName = new Comparator<Person>() {
            public int compare(final Person p1, final Person p2) {
                return p1.getFirstName().compareTo(p2.getFirstName());
            }
        };
        Person p1 = new Person();
        p1.setFirstName("a");
        p1.setLastName("a");
        Person p2 = new Person();
        p2.setFirstName("b");
        p2.setLastName("a");
        Person p3 = new Person();
        p3.setFirstName("b");
        p3.setLastName("b");
        List<Person> persons = Lists.newArrayList(p1,p2,p3,null);
        List<Person> sortedCopy = Ordering.natural().nullsLast().from(byLastName).compound(byFirstName).sortedCopy(persons);
        System.out.println(persons);
        System.out.println(sortedCopy);

    }
    @Test
    public void testPartition(){
        List<Long> parentList = Lists.newLinkedList();
        for (long i =0; i< 123;i++){
            parentList.add(i);
        }

        List<List<Long>> list= Lists.partition(parentList,10);
        System.out.print(list.size());
//        b
//        c
//        d
    }

    @Test
    public void testMath(){
//        System.out.println(IntMath.divide(10,3, RoundingMode.DOWN));
//        System.out.println(IntMath.divide(10,3, RoundingMode.UP));
        NumberFormat format = NumberFormat.getPercentInstance();// 获取格式化类实例
        format.setMinimumFractionDigits(4);// 设置小数位
        System.out.println(format.format(4/ 6 ));// 打印计算结果
//        System.out.println(BigDecimal.valueOf(10).divide(new BigDecimal("0"),2, BigDecimal.ROUND_HALF_UP));
        System.out.println(4/ 6);

    }

}
