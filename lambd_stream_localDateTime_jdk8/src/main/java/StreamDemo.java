import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ClassName: PACKAGE_NAME
 * Function: Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象。
 * 将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等。
 *
 * Stream特性：
 * 不是数据结构：它没有内部存储，它只是用操作管道从 source（数据结构、数组、generator function、IO channel）抓取数据。它也绝不
 * 修改自己所封装的底层数据结构的数据。例如 Stream 的 filter 操作会产生一个不包含被过滤元素的新 Stream，而不是从 source 删除那些元素。
 * 不支持索引访问：但是很容易生成数组或者 List 。
 * 惰性化：很多 Stream 操作是向后延迟的，一直到它弄清楚了最后需要多少数据才会开始。Intermediate 操作永远是惰性化的。
 * 并行能力。当一个 Stream 是并行化的，就不需要再写多线程代码，所有对它的操作会自动并行进行的。
 * 可以是无限的：集合有固定大小，Stream 则不必。limit(n) 和 findFirst() 这类的 short-circuiting 操作可以对无限的 Stream 进行运算并很快完成。
 * 注意事项：所有 Stream 的操作必须以 lambda 表达式为参数。
 *
 * Stream 流操作类型：
 * Intermediate：一个流可以后面跟随零个或多个 intermediate 操作。其目的主要是打开流，做出某种程度的数据映射/过滤，然后返回一个
 * 新的流，交给下一个操作使用。这类操作都是惰性化的（lazy），就是说，仅仅调用到这类方法，并没有真正开始流的遍历。
 * Terminal：一个流只能有一个 terminal 操作，当这个操作执行后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。
 * Terminal操作的执行，才会真正开始流的遍历，并且会生成一个结果，或者一个 side effect。
 *
 * Reason: TODO
 * Date: 2020/8/14
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class StreamDemo {
    public static void main(String[] args) {
        summaryStatistics();
    }

    /**
     * Stream流的summaryStatistics使用
     */
    private static void summaryStatistics() {
        List<Integer> list = Arrays.asList(1, 5, 7, 3, 9);
        IntSummaryStatistics stats = list.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

    /**
     * groupingBy：分组排序；
     * partitioningBy：分区排序。
     */
    private static void groupingPartitioningBy() {
        System.out.println("通过id进行分组排序:");
        Map<Integer, List<User>> group = Stream.generate(new UserSupplier()).limit(5)
                .collect(Collectors.groupingBy(User::getId));
        group.entrySet().forEach(en -> {
            System.out.println("id " + en.getKey() + " = " + en.getValue());
        });

        System.out.println("通过年龄进行分区排序:");
        Map<Boolean, List<User>> person = Stream.generate(new UserSupplier()).limit(5)
                .collect(Collectors.partitioningBy(user -> user.getId() < 20));
        System.out.println("小孩: " + person.get(true));
        System.out.println("成年人: " + person.get(false));
    }

    /**
     * 通过实现Supplier类的方法可以自定义流计算规则。
     */
    private static void generateSupplier() {
        System.out.println("自定义一个流进行计算输出:");
        Stream.generate(new UserSupplier())
                .limit(2)
                .forEach(System.out::println);
    }

    private static void iterate() {
        System.out.println("从2开始生成一个等差队列:");
        Stream.iterate(2, n-> n+2 ).limit(5).forEach(x-> System.out.print(x + " "));
    }

    /**
     * 把 Stream 元素组合起来进行操作。
     */
    private static void reduce() {
        String concat = Stream.of("a", "b", "c", "d").reduce("prefix_", String::concat);
        System.out.println("字符串拼接:" + concat);

        // 最小值
        Double min = Stream.of(-4.0d, 1.0d, 2.0d, 4.4d).reduce(Double.MAX_VALUE, Double::min);
        System.out.println("最小值:" + min);

        // 求和, 无起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println("有无起始值求和:" + sumValue);
        // 求和, 有起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(1, Integer::sum);
        System.out.println("有起始值求和:" + sumValue);

        //过滤拼接
        concat = Stream.of("a", "B", "c", "D", "e", "F")
                .filter(x -> x.compareTo("Z") > 0)
                .reduce("",String::concat);
        System.out.println("过滤和字符串连接:" + concat);
    }

    /**
     * Stream流的Match使用
     */
    private static void xxxMatch() {
        List<Integer> list =  new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(4);
                add(10);
            }
        };
        boolean all = list.stream().allMatch(v -> v > 3);
        boolean any = list.stream().anyMatch(v -> v > 3);
        boolean none = list.stream().noneMatch(v -> v > 10);
        System.out.println("是否都大于3:" + all);
        System.out.println("是否有一个大于3:" + any);
        System.out.println("是否没有一个大于10的:" + none);
    }

    /**
     * Stream流的max/min/distinct使用
     */
    private static void maxMinDistinct() {
        // 得到最大最小值
        List<String> list13 = Arrays.asList("zhangsan","lisi","wangwu","xuwujing");
        int max = list13.stream().mapToInt(String::length).max().getAsInt();
        int min = list13.stream().mapToInt(String::length).min().getAsInt();
        System.out.println("最长字符的长度:" + max+",最短字符的长度:"+min);

        //distinct 得到去重之后的数据
        String lines = "good good study day day up";
        List<String> list14 = new ArrayList<String>();
        list14.add(lines);
        List<String> words = list14.stream().flatMap(line -> Stream.of(line.split(" ")))
                .filter(str -> str.length() > 0)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("去重复之后:" + words);
    }

    /**
     * parallelStream 是流并行处理程序的代替方法。
     */
    private static void parallelStream() {
        List<String> strings = Arrays.asList("a", "", "c", "", "e","", " ");
        // 获取空字符串的数量
        long count = strings.parallelStream().filter(str -> str.isEmpty()).count();
        System.out.println("空字符串的个数:"+count);
    }

    /**
     * peek对每个元素执行操作并返回一个新的Stream
     */
    private static void peek() {
        System.out.println("peek使用:");
        List<String> list = Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
                .peek(e -> System.out.println("转换前： " + e))
                .map(String::toUpperCase)
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * tips:先获取在排序效率会更高!
     */
    private static void sort() {
        new Random().ints().limit(4).sorted().forEach(System.out::println);
        List<User> users = new ArrayList<>();
        users.add(new User(2, "apple2"));
        users.add(new User(1, "apple1"));
        users.add(new User(3, "apple3"));
        long start = System.currentTimeMillis();
        List<User> sort1 = users.stream().sorted((u1, u2) -> u1.getName().compareTo(u2.getName())).collect(Collectors.toList());
        long end1 = System.currentTimeMillis();
        System.out.println("普通排序耗时: "+ (end1 -start));
        List<User> sort2 = users.stream().limit(3).sorted((u1, u2) -> u1.getName().compareTo(u2.getName())).collect(Collectors.toList());
        long end2 = System.currentTimeMillis();
        System.out.println("优化排序耗时: "+ (end2 -end1));
        System.out.println("排序之后的数据： "+ sort1);
        System.out.println("优化排序(先获取数据防惰性)之后的数据： "+ sort2);
    }

    private static void skip() {
        Random rnd = new Random();
        System.out.println("前3条数据: ");
        rnd.ints( ).limit(3).forEach(System.out::println);
        System.out.println("截取前2个：");
        rnd.ints(3 ).limit(3).skip(2).forEach(System.out::println);
    }

    private static void limit() {
        Random rnd = new Random();
        System.out.println("前3条数据: ");
        rnd.ints().limit(3).forEach(System.out::println);
        System.out.println("截取");
    }

    private static void flatMap() {
        //Stream流的flatMap使用 从句子中得到单词
        System.out.println("Stream流的flatMap使用 从句子中得到单词: ");
        String worlds = "The way of the future";
        List<String> list7 = new ArrayList<>();
        list7.add(worlds);
        List<String> list8 = list7.stream().flatMap(str -> Stream.of(str.split(" ")))
                .filter(w -> w.length() > 0).collect(Collectors.toList());
        System.out.println("单词： "+ list8);
    }

    /**
     * 构建流
     */
    private static void constructStream() {
        System.out.println("===构建流===");
        Stream<String> st1 = Stream.of("a", "b", "c");

        String[] strArray = new String[]{"a", "b", "c"};
        Stream<String> st2 = Stream.of(strArray);

        Stream<String> st3 = Arrays.stream(strArray);

        List<String> list = Arrays.asList(strArray);
        list.stream();
    }

    /**
     * 流的转换
     * 一个Stream流只可以使用一次，这段代码为了简洁而重复使用了数次，
     * 抛出 stream has already been operated upon or closed 异常。
     */
    private static  void transformStream(){
        try {
            Stream<String> stream = Stream.of("a", "b", "c");

            //转成Array
            Object[] strArray = stream.toArray(String[]::new);

            //转成 Collection
            List<String> list1 = stream.collect(Collectors.toList());
            ArrayList<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
            Set<String> set = stream.collect(Collectors.toSet());
            Stack<String> stack = stream.collect(Collectors.toCollection(Stack::new));

            //转成String
            String str = stream.collect(Collectors.joining());

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * map映射每个元素到每个结果  一对一
     */
    private static void  mapUse(){
        System.out.println("===Stream流的map使用===");
        System.out.println("===大小写转换===");
        List<String> list = Arrays.asList("zhangSan", "liSi", "wangWu");
        System.out.println("转换之前的数据:" + list);
        List<String> list1 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("转换之后的数据:" + list1);

        System.out.println("===数据类型转换===");
        List<String> list31 = Arrays.asList("1", "2", "3");
        System.out.println("转换之前的数据:" + list31);
        List<Integer> list41 = list31.stream().map(Integer::valueOf).collect(Collectors.toList());
        System.out.println("转换之后的数据:" + list41);

        List<Integer> list5 = list41.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("计算平方的数据:" + list5);
    }

    /**
     * filter方法用于通过设置的条件过滤出元素。
     */
    private static void filterUse(){
        System.out.println("===Stream流的filter使用===");
        List<String> list = Arrays.asList("张三", "李四", "王五", "xuwujing");
        System.out.println("过滤前数据：" + list);
        String res1= list.stream().filter(str -> str.equals("李四")).findAny().orElse("找不到");
        List<String> list2 = list.stream().filter(str -> !str.equals("李四")).collect(Collectors.toList());
        System.out.println("过滤后数据：" + list2);

    }

    /**
     * 通过与 mapToInt 计算和
     */
    private  void mapToInt(){
        System.out.println("===通过与 mapToInt 计算和===");
        List<User> lists = new ArrayList<User>();
        lists.add(new User(6, "张三"));
        lists.add(new User(2, "李四"));
        lists.add(new User(3, "王五"));
        lists.add(new User(1, "张三"));
        // 计算这个list中出现 "张三" id的值
        int sum = lists.stream().filter(u -> "张三".equals(u.getName())).mapToInt(u -> u.getId())
                .sum();
        System.out.println("计算结果:" + sum);


    }
}
