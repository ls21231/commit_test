package com.ls.db.mapper;

import com.ls.db.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ls
 * @create 2022 -- 08 -- 29
 */

@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();
}
