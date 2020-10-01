package com.at.common.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Timestamp;

/**
 * @author Zheng Jie
 * @date 2019年10月24日20:48:53
 */
@Getter
@Setter
public class BaseDTO  implements Serializable {

    private String createBy;

    private String updatedBy;

    private Timestamp createTime;

    private Timestamp updateTime;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Field[] fields = this.getClass().getDeclaredFields();
        try {
            for (Field f : fields) {
                f.setAccessible(true);
                builder.append(f.getName()).append(f.get(this)).append("\n");
            }
        } catch (Exception e) {
            builder.append("toString builder encounter an error");
        }
        return builder.toString();
    }
}
