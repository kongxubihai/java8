import java.awt.Color;

/**
 * ClassName: PACKAGE_NAME
 * Function: 用法三 向枚举中添加新的方法
 * 如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。
 * Reason: TODO
 * Date: 2020/8/18
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class Usage3 {
    public static void main(String[] args) {
        System.out.println(Color.GREEN.getIndex());
        System.out.println(Color.RED.getName());
    }

    enum Color {
        RED("红色", 0), GREEN("蓝色", 1);
        // 成员变量
        private String name;
        private int index;

        //getter setter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        /**
         * 构造方法
         *
         * @param name
         * @param index
         */
        Color(String name, int index) {
            this.name = name;
            this.index = index;
        }

        /**
         * 普通方法
         *
         * @param index
         * @return
         */
        public static String getName(int index) {
            for (Color color : Color.values()) {
                if (color.getIndex() == index) {
                    return color.getName();
                }
            }
            return null;
        }
    }
}


