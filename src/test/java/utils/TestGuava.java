package utils;

import com.alibaba.fastjson.JSONObject;
import com.github.base.json.JsonPageResponse;
import com.github.base.utils.MathUtils;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.math.IntMath;
import com.ning.http.client.*;
import model.Person;
import org.junit.Test;

import javax.net.ssl.SSLSocketFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

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
    @Test
    public void testResponse(){
        System.out.println(JSONObject.toJSONString(JsonPageResponse.success(null)));
    }

    @Test
    public void testJsoup(){
        String queryURL = "http://e.tf.360.cn/search/rec?p=ZWcCsN1c4EEH8dg1vV7%2FQxLxFXZyFXboSU836tD1D3%2FKvRayn41%2F6zcr7Oh1t8HycM3Io3o9TXo3rJ0stAZnXzwJ81RdaBx3qbhUgCWd%2BDbmO3korU%2FAqxRRWK7kB361PoR99AwrxpSD8W7x41%2By3zjJvLEunm9jtsIS8xGT80g2NsqGBjnEkHBcRz75H%2FwcBsLevUFSpUYSaSXMMttHUK0Vd6NMI1QlMUqsyFwTX%2FFNcri1HwKwC%2B0A1BnFj4V7%2BO7ImrYBPf9bJU2fVxo7d6S0Q4tXwpwnN2pUdE8YQ0Q%2FI38S8FVH0ZAT9llniLQrEc6ja6rN4bq7WiD0swJ3H6D7WPhj1jOPn9mCFmaxdW4%3D&pl=364&t=14615555948647";
        byte[] responseBody = null;
//        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {
            AsyncHttpClient client = new AsyncHttpClient(new AsyncHttpClientConfig.Builder().setAcceptAnyCertificate(false).build());
            Future<Response> f = client.prepareGet(queryURL).execute();
            Response response = f.get();
            System.out.println(response.getResponseBody());
//            responseBody = getBytesFromInpuStream(f.get().getResponseBodyAsStream());
        } catch (Exception e) {
//            throw new HttpClientException(e);
            e.printStackTrace();
        }
       /* try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("ss");
//        System.out.println(new String(responseBody));
    }
    private byte[] getBytesFromInpuStream(InputStream instream) throws IOException {
        ByteArrayOutputStream outstream = new ByteArrayOutputStream();
        try {
            int length;
            byte[] tmp = new byte[8096];
            while ((length = instream.read(tmp)) != -1) {
                outstream.write(tmp, 0, length);
            }
            return outstream.toByteArray();
        } finally {
            instream.close();
            outstream.close();
        }
    }
    @Test
    public void testMath2(){
        String str = MathUtils.getPercent(Integer.valueOf(6) - Integer.valueOf(2), Integer.valueOf(6));
        System.out.println(Integer.valueOf(6) - 1);
    }
}
