/**
 * ClassName: PACKAGE_NAME
 * Function: 用法二 switch
 * Reason: TODO
 * Date: 2020/8/18
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class Usage2 {
    public static void main(String[] args) {
        Signal color = Signal.RED;
        switch (color) {
            case GREEN:
                break;
            case YELLOW:
                break;
            case RED:
                break;
        }
    }
}

enum Signal{
    GREEN, YELLOW, RED
}
