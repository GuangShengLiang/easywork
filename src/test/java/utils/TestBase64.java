package utils;

import jodd.util.Base64;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

/**
 * Created by lgs on 16-2-3.
 */
public class TestBase64 {

    @Test
    public void testBase(){
        String str = "abcdef";
        String encodeStr = Base64.encodeToString(str);
        System.out.println(encodeStr);
        String decodeStr = Base64.decodeToString(encodeStr);
        System.out.println(decodeStr);
        Assert.assertEquals(decodeStr,str);
    }
    @Test
    public void testMd5(){
        Short a = null;
        System.out.println(String.valueOf(a));
    }

    public <S, D> void a(List<S> list, final Function<S,D> function){
        final ConcurrentLinkedQueue<S> queue = new ConcurrentLinkedQueue<S>(list);
        //线程数
        int threadNum = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        final CountDownLatch latch = new CountDownLatch(threadNum);

        for (int i = 0; i < threadNum; i++) {
            executorService.execute(new Runnable() {
//                @Override
                public void run() {
                    while (!queue.isEmpty()) {
                        try {
                            function.apply(queue.poll());
//                            process(queue.poll());
                        }catch (Exception e){
//                            log.error("agentCoinInit", e);
                        }
                    }
                    latch.countDown();
                }
            });
        }
        try {
            latch.await();
            executorService.shutdown();

        } catch (InterruptedException e) {
//            log.error("InterruptedException", e);
        }
    }
}
