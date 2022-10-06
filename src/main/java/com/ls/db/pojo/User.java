package com.ls.db.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ls
 * @create 2022 -- 08 -- 29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String email;

}
