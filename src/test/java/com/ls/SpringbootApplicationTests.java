package com.ls;

import com.ls.db.mapper.UserMapper;
import com.ls.db.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass().getName());

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
//        PreparedStatement preparedStatement = connection.prepareStatement("select * from t_user");
//        boolean execute = preparedStatement.execute();
//        System.out.println(execute);
        connection.close();
    }

    @Test
    public void test() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_user");
        System.out.println(maps);
    }
    @Test
    public void test1() {
         List<User> users = userMapper.queryUserList();
        System.out.println(users);
    }



}
