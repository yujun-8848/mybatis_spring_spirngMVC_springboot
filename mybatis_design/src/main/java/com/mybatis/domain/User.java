package com.mybatis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * user表
 */

@Data
@NoArgsConstructor
public class User implements Serializable {

    private Integer id;
    private String username;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String sex;
    private String address;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
