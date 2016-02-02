package utils;

import jodd.datetime.JDateTime;
import jodd.datetime.format.JdtFormat;
import jodd.datetime.format.JdtFormatter;
import jodd.format.Printf;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author lgs
 * @Date 15-12-7 上午10:25
 */
@Slf4j()
public class TestJDateTime {

    @Test
    public void testConstructor(){
        JDateTime jdt = new JDateTime();            // current date and time
        jdt = new JDateTime(2012, 12, 21);         // 21st December 2012, midnight

        System.out.println(jdt.toString());
        jdt = new JDateTime(System.currentTimeMillis());    // current date and time
        System.out.println(jdt.toString());

        jdt = new JDateTime(2012, 12, 21, 11, 54, 22, 124); // 21.Dec.2012,11:54:22.124
        System.out.println(jdt.toString());

        jdt = new JDateTime("2012-12-21 11:54:22.124");     // -//-
        System.out.println(jdt.toString());

        jdt = new JDateTime("12/21/2012", "MM/DD/YYYY");    // 21st Dec. 2012, midnight
        System.out.println(jdt.toString());

    }

    @Test
    public void testToString(){
        JDateTime jdt = new JDateTime(System.currentTimeMillis());
        jdt.toString();                     // "1975-01-01 00:00:00.000"
        jdt.addDay(-1);
        System.out.println(jdt.toString("YYYY-MM-DD hh:mm:ss"));

        jdt.toString("YYYY.MM.DD");         // "1975.01.01"
        jdt.toString("MM: MML (MMS)");      // "01: January (Jan)"
        jdt.toString("DD is D: DL (DS)");   // "01 is 3: Wednesday (Wed)"
        JDateTime jdt2 = new JDateTime(1968, 9, 30);
        jdt2.toString("'''' is a sign, W is a week number and 'W' is a letter");
        // "' is a sign, 5 is a week number and W is a letter"

        jdt2.parse("2003-11-24 23:18:38.173");
        jdt2.parse("2003-11-23");                // 2003-11-23 00:00:00.000
        jdt2.parse("01.01.1975", "DD.MM.YYYY");  // 1975-01-01
        jdt2.parse("2001-01-31", "YYYY-MM-***"); // 2001-01-01, since day is not parsed


    }
    @Test
    public void testFormatter(){
     /*   JDateTime jdt = new JDateTime();
        JdtFormatter fmt = new DefaultFormatter();
        fmt.convert(jdt, "YYYY-MM.DD");         // external conversion

        JdtFormat format = new JdtFormat(new DefaultFormatter(), "YYYY+DD+MM");
        jdt.toString(format);
        format.convert(jdt);

        DateFormat df = new SimpleDateFormat();
        df.format(jdt.convertToDate());         // date formatter*/
    }


}
