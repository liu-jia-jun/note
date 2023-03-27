package datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Set;

/**
 * @author 刘佳俊
 */
public class DateTimeTest {

    //===========================================本地时间 / 日期=====================================================

    public void test01(){
        //获取当前时间日期 now
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);

        //指定时间日期 of
        LocalDateTime ldt2 = LocalDateTime.of(2020, 05, 17, 16, 24, 33);
        System.out.println(ldt2);

        //加 plus
        LocalDateTime ldt3 = ldt2.plusYears(2);
        System.out.println(ldt3);

        //减 minus
        LocalDateTime ldt4 = ldt2.minusMonths(3);
        System.out.println(ldt4);

        //获取指定的你年月日时分秒... get
        System.out.println(ldt2.getDayOfYear());
        System.out.println(ldt2.getHour());
        System.out.println(ldt2.getSecond());
    }
    //===========================================时间戳=====================================================

    public void test02(){
        // 默认获取 UTC 时区 (UTC：世界协调时间)
        Instant ins1 = Instant.now();
        System.out.println(ins1);

        //带偏移量的时间日期 (如：UTC + 8)
        OffsetDateTime odt1 = ins1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt1);

        //转换成对应的毫秒值
        long milli1 = ins1.toEpochMilli();
        System.out.println(milli1);

        //构建时间戳
        Instant ins2 = Instant.ofEpochSecond(60);
        System.out.println(ins2);
    }


    //===============================时间差===================================================================


    /*
        Duration：计算两个时间之间的间隔
        Period：计算两个日期之间的间隔
     */

    public void test03(){
        //计算两个时间之间的间隔 between
        Instant ins1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant ins2 = Instant.now();
        Duration dura1 = Duration.between(ins1, ins2);
        System.out.println(dura1.getSeconds());
        System.out.println(dura1.toMillis());
    }


    public void test04(){
        LocalDate ld1 = LocalDate.of(2016, 9, 1);
        LocalDate ld2 = LocalDate.now();
        Period period = Period.between(ld1, ld2);  // ISO 标准
        System.out.println(period.getYears());
        System.out.println(period.toTotalMonths());
    }


    //======================================时间校正器===============================================

    public void test05(){
        //TemporalAdjusters：时间校正器
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);

        //指定日期时间中的 年 月 日 ...
        LocalDateTime ldt2 = ldt1.withDayOfMonth(10);
        System.out.println(ldt2);

        //指定时间校正器
        LocalDateTime ldt3 = ldt1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        //自定义时间校正器
        LocalDateTime ldt5 = ldt1.with((ta) -> {
            LocalDateTime ldt4 = (LocalDateTime) ta;
            DayOfWeek dow1 = ldt4.getDayOfWeek();
            if (dow1.equals(DayOfWeek.FRIDAY)) {
                return ldt4.plusDays(3);
            } else if (dow1.equals(DayOfWeek.SATURDAY)) {
                return ldt4.plusDays(2);
            } else {
                return ldt4.plusDays(1);
            }
        });
        System.out.println(ldt5);
    }

    //=========================================时间格式化==========================================

    public void test06(){
        //默认格式化
        DateTimeFormatter dtf1 = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt1 = LocalDateTime.now();
        String str1 = ldt1.format(dtf1);
        System.out.println(str1);

        //自定义格式化 ofPattern
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt2 = LocalDateTime.now();
        String str2 = ldt2.format(dtf2);
        System.out.println(str2);

        //解析
        LocalDateTime newDate = ldt1.parse(str1, dtf1);
        System.out.println(newDate);
    }


    //====================================时区====================================================

    public void test07(){
        //查看支持的时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);

        //指定时区
        LocalDateTime ldt1 = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        System.out.println(ldt1);

        //在已构建好的日期时间上指定时区
        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        ZonedDateTime zdt1 = ldt2.atZone(ZoneId.of("Europe/Tallinn"));
        System.out.println(zdt1);
    }




    public void test08(){
        // Date 转 LocalDateTime
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();

        // LocalDateTime 转 Date
        LocalDateTime localDateTime1 = LocalDateTime.now();
        ZoneId zoneId1= ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date1 = Date.from(zdt.toInstant());

        // 原则：利用 时间戳Instant
    }




}
