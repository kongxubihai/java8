package demo;

import lombok.Builder;
import lombok.Data;

/**
 * @author zfd
 * @version v1.0
 * @description TODO
 * @date 2021/1/20 17:52
 */
@Data
@Builder
public class User {

    private String name;

    private String gender;

    private School school;

    @Data
    public static class School {

        private String scName;

        private String address;
    }

}
