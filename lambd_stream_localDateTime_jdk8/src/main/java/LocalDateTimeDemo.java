import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * ClassName: PACKAGE_NAME
 * Function: java.time包，该包下的所有类都是不可变类型而且线程安全
 * 关键类
 * Instant：瞬时时间。
 * LocalDate：本地日期，不包含具体时间, 格式 yyyy-MM-dd。
 * LocalTime：本地时间，不包含日期. 格式HH:mm:ss.SSS 。
 * LocalDateTime：组合了日期和时间，但不包含时差和时区信息。
 * ZonedDateTime：最完整的日期时间，包含时区和相对UTC或格林威治的时差。
 * Date: 2020/8/18
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        formatted();
    }

    /**
     * 使用预定义的格式化工具去解析或格式化日期
     */
    private static void formatted() {
        String dateStr="20200818";
        LocalDate formatted = LocalDate.parse(dateStr, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dateStr, formatted);
    }

    /**
     * 带时区偏移量
     */
    private static void zoneOffSet() {
        LocalDateTime now = LocalDateTime.now();
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime dateTime = OffsetDateTime.of(now, offset);
        System.out.println("Date and Time with timezone offset in Java : " + dateTime);
    }

    /**
    * 检查闰年
     **/
    public static void isLeapYear(){
        LocalDate today = LocalDate.now();
        if(today.isLeapYear()){
            System.out.println("This year is Leap year");
        }else {
            System.out.println("2018 is not a Leap year");
        }
    }

    /**
     * 使用 YearMonth类处理特定的日期 也可以获取某月的总共多少天
     *
     */
    public static void checkCardExpiry(){
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());

        YearMonth creditCardExpiry = YearMonth.of(2028, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
    }

    /**
     *处理周期性的日期
     * 检查像生日这种周期性事件 MonthDay YearMonth
     */
    private static void cycleDate() {
        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(2010, 8, 18);
        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay= MonthDay.from(today);
        System.out.println("today is one's  birthday? " +
                currentMonthDay.equals(birthday));
    }

    /**
     * 时区时间计算
     * 示例一:通过Clock时钟类获取计算
     * 示例二:通过ZonedDateTime类和ZoneId
     */
    private static void clockAndZonedDateTime() {
        System.out.println("当前时间戳： "+ System.currentTimeMillis());
        Clock clock = Clock.systemUTC();
        System.out.println("当前时间戳 : " + clock.millis());
        Clock clock2 = Clock.system(ZoneId.of("Asia/Shanghai"));
        System.out.println("亚洲上海此时的时间戳:"+clock2.millis());
        Clock clock3 = Clock.system(ZoneId.of("America/New_York"));
        System.out.println("美国纽约此时的时间戳:"+clock3.millis());

        //通过ZonedDateTime类和ZoneId
        ZoneId zoneId = ZoneId.of("America/New_York");
        ZonedDateTime dateTime = ZonedDateTime.now(zoneId);
        System.out.println("美国纽约此时的时间 : " + dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        System.out.println("美国纽约此时的时间 和时区: " + dateTime);
        System.out.println("默认的时间和时区"+ ZonedDateTime.now());
    }

    /**
     * 日期时间比较大小和计算相差
     */
    private static void compareAndCount() {
        LocalDate ld=LocalDate.parse("2017-03-17");
        LocalDate ld2=LocalDate.parse("2017-02-05");
        Period p = Period.between(ld, ld2);
        System.out.println("相差年: "+p.getYears()+" 相差月 :"+p.getMonths() +" 相差天:"+p.getDays());
        // ChronoUnit 日期周期单位的标准集合。
        System.out.println("相差月份： " + ChronoUnit.MONTHS.between(ld, ld2));
        System.out.println("相差天数： " + ChronoUnit.DAYS.between(ld, ld2));

        //计算时分秒
        LocalDateTime ldt = LocalDateTime.of(2020, 12, 12, 12, 12, 12);
        LocalDateTime ldt2 = LocalDateTime.of(2020, 12, 10, 9, 59, 32);
        System.out.println("相差小时： " + ChronoUnit.HOURS.between(ldt, ldt2));
        System.out.println("相差分钟： " + ChronoUnit.MINUTES.between(ldt, ldt2));
        System.out.println("相差秒数： " + ChronoUnit.SECONDS.between(ldt, ldt2));

        // 精确时间相差 Duration 这个类以秒和纳秒为单位建模时间的数量或数量。
        Instant inst1 = Instant.now();
        System.out.println("当前时间戳" + inst1);
        Instant inst2 = inst1.plus(Duration.ofSeconds(20));
        System.out.println("增加之后的时间" + inst2);
        System.out.println("相差毫秒： " + Duration.between(inst1, inst2).toMillis());
        System.out.println("相差秒： " + Duration.between(inst1, inst2).getSeconds());

        // 时间大小比较
        LocalDateTime ldt4 = LocalDateTime.now();
        LocalDateTime ldt5 = ldt4.plusMinutes(10);
        System.out.println("当前时间是否小于： "+ ldt4.isBefore(ldt5));
        System.out.println("当前时间是否大于： "+ ldt4.isAfter(ldt5));
        LocalDate ld4 = LocalDate.now();
        LocalDate ld5 = ld4.plusDays(10);
        System.out.println("当前日期是否小于： "+ ld4.isBefore(ld5));
        System.out.println("当前日期是否大于： "+ ld4.isAfter(ld5));
        System.out.println("当前日期是否等于： "+ ld4.isEqual(ld5));

    }

    private static void create() {
        System.out.println(LocalDate.of(2020, Month.DECEMBER, 17));
        System.out.println(LocalDate.of(2020, 10, 20));
    }

    /**
     * 在指定的时间进行增加/减少年月日时分秒。
     */
    private static void plusAndMinus() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("后5天时间:" + ldt.plusDays(5));
        System.out.println("前5天时间并格式化:" + ldt.minusDays(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println("前一个月的时间:" + ldt.minusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMM")));
        System.out.println("后一个月的时间:" + ldt.plusMonths(1));
        System.out.println("指定2099年的当前时间:" + ldt.withYear(2099));
    }

    /**
     * 格式时间格式需要用到DateTimeFormatter类。
     */
    private static void format() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("格式化后的时间: " + ldt.format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        ));
    }

    /**
     * 获取当前的年月日时分秒
     */
    private static void getDetail() {
        //获取当前的时间，包括毫秒
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("当前年:" + ldt.getYear());
        System.out.println("当前年份天数:" + ldt.getDayOfYear());
        System.out.println("当前月:" + ldt.getMonthValue());
        System.out.println("当前时:" + ldt.getHour());
        System.out.println("当前分:" + ldt.getMinute());
        System.out.println("当前秒:" + ldt.getSecond());
        System.out.println("当前时间:" + ldt.toString());
    }

    /**
     * 当前日期和时间
     */
    private static void now() {
        //本地日期,不包括时分秒
        LocalDate nowDate = LocalDate.now();
        //本地日期,包括时分秒
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("当前时间:" + nowDate);
        System.out.println("当前时间:" + nowDateTime);
    }
}
