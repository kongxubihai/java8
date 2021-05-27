import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 *
 *@author zfd
 *@date 2021/5/25 10:27
 *@version v1.0
 */
public class PatternDemo {
    public static void main(String[] args) {
//        testPattern();
        testGroup();
    }

    /**
     * 测试Pattern
     */
    private static void testPattern() {
        String content = "I am noob from runoob.com.";
        String pattern = ".*runoob.*";
        boolean matches = Pattern.matches(pattern, content);
        System.out.println(matches);
    }

    /**
     * 捕获组是把多个字符当一个单独单元进行处理的方法，它通过对括号内的字符分组来创建。
     *
     * 例如，正则表达式 (dog) 创建了单一分组，组里包含"d"，"o"，和"g"。
     *
     * 捕获组是通过从左至右计算其开括号来编号。例如，在表达式（（A）（B（C））），有四个这样的组：
     *
     * ((A)(B(C)))
     * (A)
     * (B(C))
     * (C)
     * 可以通过调用 matcher 对象的 groupCount 方法来查看表达式有多少个分组。groupCount 方法返回一个 int 值，表示matcher对象当前有多个捕获组。
     *
     * 还有一个特殊的组（group(0)），它总是代表整个表达式。该组不包括在 groupCount 的返回值中。
     */
    private static void testGroup() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        if (m.find()) {
            // 一个特殊的组（group(0)），它总是代表整个表达式。该组不包括在 groupCount 的返回值中。
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("not found");
        }
    }
}
