package cn.wangdpwin.test.base.date;

import com.alibaba.fastjson.JSON;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.Test;

/**
 * @Author: wangdongpeng
 * @Date: 2019/4/2 下午4:42
 * @Description
 * @Version 1.0
 */
public class LocalDateTimeTest {

    @Test
    public void test(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH");
        String prefix = localDateTime.format(dateTimeFormatter);
        String prefix2 = localDateTime.minusHours(2).format(dateTimeFormatter);
        System.out.println("test");
    }

    @Test
    public void LocalDateTimeString() {
        LocalDateTime dateTime = LocalDateTime.now();

        //使用预定义实例来转换
        DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;
        String dateStr = dateTime.format(fmt);
        System.out.println("LocalDateTime转String[预定义]:"+dateStr);

        //使用pattern来转换
        //12小时制与24小时制输出由hh的大小写决定
        DateTimeFormatter fmt12 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss:SSS");
        String dateStr12 = dateTime.format(fmt12);
        System.out.println("LocalDateTime转String[pattern](12小时制):"+dateStr12);

        DateTimeFormatter fmt24 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
        String dateStr24 = dateTime.format(fmt24);
        System.out.println("LocalDateTime转String[pattern](24小时制):"+dateStr24);

        //如果想要给12小时制时间加上am/pm,这样子做：
        fmt12 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss:SSS a");
        dateStr12 = dateTime.format(fmt12);
        System.out.println("LocalDateTime转String[pattern](12小时制带am/pm):"+dateStr12);
    }

    @Test
    public void read() throws IOException {
        String path = "objectLogs/result/logs/pgxcloud-results-dev-2019-04-02-14-1.log";
//        "sync/csv/pgxcloud-results-dev-2019-2019-04-02-14-1.txt"};
        File file = new File(path);
        System.out.println(file.getPath());
        System.out.println(file.getCanonicalPath());
    }

    @Test
    public void format(){
        String time = "28/Mar/2019:16:06:40";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date date = sdf.parse(time);
            System.out.println(JSON.toJSONString(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void java8(){
        DateTimeFormatter formatter =
                DateTimeFormatter
                        .ofPattern("MMM dd, yyyy - HH:mm");

        LocalDateTime parsed = LocalDateTime.parse("2014-10-24 07:13", formatter);
        String string = formatter.format(parsed);
        System.out.println(string);     // Nov 03, 2014 - 07:13
    }

    @Test
    public void dataFormat(){
        String anotherDate = "04 Apr 2016";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM yyyy",Locale.US);
        LocalDate random = LocalDate.parse(anotherDate, df);
        System.out.println(anotherDate + " parses as " + random);
    }

    @Test
    public void between(){
        /**------------------Date Time----------------------------*/
        LocalDateTime t1 = LocalDateTime.now();
        LocalDateTime t2 = LocalDateTime.now().minusMonths(3);
        long dateTimeDiff = ChronoUnit.MONTHS.between(t2, t1);
        System.out.println("diff dateTime : " + dateTimeDiff);
        /**-------------------------Date----------------------------*/
        LocalDate t3 = LocalDate.now();
        LocalDate t4 = LocalDate.now().minusMonths(3);
        long dateDiff = ChronoUnit.MONTHS.between(t4, t3);
        System.out.println("diff date : "  +  dateDiff);

        LocalDate start = LocalDate.parse("2019-01-01");
        LocalDate end = LocalDate.parse("2019-04-01");
        boolean b = start.isAfter(end);
        System.out.println(b);
    }

    @Test
    public void getFirstDayOfMonth(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfDay = now.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
        System.out.println(startOfDay);
    }
  /**
   * java8(别的版本获取2月有bug) 获取某月最后一天的23:59:59
   *
   * @return
   */
  @Test
  public void getLastDayOfMonth() {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime endOfDay = now.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
    System.out.println(endOfDay.toString());
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedDateTime = endOfDay.format(formatter);
    System.out.println(formattedDateTime);
  }


    private final static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");;
    private final static SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");;


    /**
     * 当前季度的开始时间
     *
     * @return
     */
    @Test
    public void getCurrentQuarterStartTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                c.set(Calendar.MONTH, 0);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 3);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 4);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 9);
            }
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(now.toLocaleString());
    }

    /**
     * 当前季度的结束时间
     *
     * @return
     */
    @Test
    public void getCurrentQuarterEndTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                c.set(Calendar.MONTH, 2);
                c.set(Calendar.DATE, 31);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 8);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(now.toLocaleString());
    }

    @Test
    public void minusHour(){
        LocalDateTime localDateTime = LocalDateTime.now();
        String time = localDateTime.minus(2, ChronoUnit.HOURS).toString();
        String time2 = localDateTime.withNano(0).toString();
        String time3 = localDateTime.minusNanos(1).toString();
        System.out.println(time);
        System.out.println(time2);
        System.out.println(time3);
    }


}
