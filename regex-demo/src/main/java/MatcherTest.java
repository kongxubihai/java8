import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 *
 *@author zfd
 *@date 2021/5/25 10:47
 *@version v1.0
 */
public class MatcherTest {

    /**
     * 	public int start()
     * 返回以前匹配的初始索引。
     * 2	public int start(int group)
     *  返回在以前的匹配操作期间，由给定组所捕获的子序列的初始索引
     * 3	public int end()
     * 返回最后匹配字符之后的偏移量。
     * 4	public int end(int group)
     * 返回在以前的匹配操作期间，由给定组所捕获子序列的最后字符之后的偏移量
     */
    @Test
    public void testStart() {
        // 下面是一个对单词 "cat" 出现在输入字符串中出现次数进行计数的例子：
        String regex = "\\bcat\\b";
        String input = "cat cat cat cattie cat";

        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(input);
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Match num: " + count);
            System.out.println("start() " + matcher.start());
            System.out.println("end() " + matcher.end());
        }
    }

    /**
     * 1	public boolean lookingAt()
     *  尝试将从区域开头开始的输入序列与该模式匹配。
     * 2	public boolean find()
     * 尝试查找与该模式匹配的输入序列的下一个子序列。
     * 3	public boolean find(int start）
     * 重置此匹配器，然后尝试查找匹配该模式、从指定索引开始的输入序列的下一个子序列。
     * 4	public boolean matches()
     * 尝试将整个区域与模式匹配。
     */
    @Test
    public void testLookingAt() {
        final String REGEX = "foo";
        final String INPUT = "fooooooooooooooooo";
        final String INPUT2 = "ooooofoooooooooooo";

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        Matcher matcher2 = pattern.matcher(INPUT2);

        System.out.println("lookingAt() " + matcher.lookingAt());
        System.out.println("matches() " + matcher.matches());
        System.out.println("lookingAt() " + matcher2.lookingAt());
        System.out.println("find() " + matcher2.find());
        System.out.println("find() " + matcher2.find(7));
    }

    /**
     * 替换方法是替换输入字符串里文本的方法：
     *
     * 3	public String replaceAll(String replacement)
     *  替换模式与给定替换字符串相匹配的输入序列的每个子序列。
     * 4	public String replaceFirst(String replacement)
     *  替换模式与给定替换字符串匹配的输入序列的第一个子序列。
     * 5	public static String quoteReplacement(String s)
     * 返回指定字符串的字面替换字符串。这个方法返回一个字符串，就像传递给Matcher类的appendReplacement 方法一个字面字符串一样工作。
     */
    @Test
    public void testReplace() {
        String regex = "dog";
        String input = "The dog says meow. All dogs say meow.";
        String replace = "cat";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String newStr = matcher.replaceAll(replace);
        System.out.println(newStr);
    }

    /**
     *      * 序号	方法及说明
     *      * 1	public Matcher appendReplacement(StringBuffer sb, String replacement)
     *      * 实现非终端添加和替换步骤。
     *      * 2	public StringBuffer appendTail(StringBuffer sb)
     *      * 实现终端添加和替换步骤。
     */
    @Test
    public void testReplace2() {
        String regex = "a*b";
        String input = "aabfooaabfooabfoobkkk";
        String replace = "-";
        Pattern compile = Pattern.compile(regex);
        Matcher m = compile.matcher(input);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, replace);
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }


}
