/**
 * ClassName: PACKAGE_NAME
 * Function: 用法四 覆盖枚举的默认方法
 * Reason: TODO
 * Date: 2020/8/18
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class Usage4 {
    enum Color {
        RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLOW("黄色", 4);
        // 成员变量
        private String name;
        private int index;

        // 构造方法
        private Color(String name, int index) {
            this.name = name;
            this.index = index;
        }

        //覆盖方法
        @Override
        public String toString() {
            return this.index + "_" + this.name;
        }

    }
}
