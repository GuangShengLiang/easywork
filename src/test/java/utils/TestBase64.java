package utils;

import jodd.util.Base64;
import org.junit.Assert;
import org.junit.Test;

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
    }
}
