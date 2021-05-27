import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式用例
 *
 *@author zfd
 *@date 2021/5/25 11:14
 *@version v1.0
 */
public class Demo {

    @Test
    public void test1() {
        //查找以Java开头,任意结尾的字符串
        Pattern p = Pattern.compile("^Java.*");
        Matcher matcher = p.matcher("Java不是人吗");
        System.out.println(matcher.matches());
    }

    @Test
    public void test2() {
        // 以多条件分割字符串时
        Pattern p = Pattern.compile("[,|]+");
        String[] strs = p.split("Java Hello World Java,Hello,,World|Sun");
        for (String str : strs) {
            System.out.println(str);
        }
    }

    @Test
    public void test3() {
        Pattern pattern = Pattern.compile("正则表达式");
        Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
        //替换第一个符合正则的数据
        System.out.println(matcher.replaceFirst("Java"));
        // 全部替换
        System.out.println(matcher.replaceAll("Java"));
        // 文字替换（置换字符）
        matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
        StringBuffer sbr = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sbr, "Java");
        }
        matcher.appendTail(sbr);
        System.out.println(sbr.toString());
    }

    /**
     * 验证是否为邮箱地址
     */
    @Test
    public void test4() {
        String str = "ceponline@yahoo.com.cn";
        String regex = "[\\w\\.\\-]+@[\\w]+\\.[\\w\\.\\-]+";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.matches());
    }

    /**
     * ◆查找html中对应条件字符串
     */
    @Test
    public void test5() {
        Pattern pattern = Pattern.compile("href=\"(.+?)\"");
        Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
        if (matcher.find())
            System.out.println(matcher.group(1));

    }

    /**
     * 去除html标记
     */
    @Test
    public void test6() {
        Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>123");
        String string = matcher.replaceAll("");
        System.out.println(string);
    }

    /**
     * 截取http://地址
     */
    @Test
    public void test7() {
        Pattern pattern = Pattern.compile("(https://|http://){1}[\\w\\.\\-\\:/]+");
        String str = "dsdsds<http://dsds//gfgffdfd>fdf";
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }

}

