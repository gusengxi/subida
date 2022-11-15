package com.subida.subida;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.subida.entity.Admin;
import com.subida.mapper.AdminMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@SpringBootTest
class SubidaApplicationTests {

    @Autowired
    private AdminMapper adminmp;




    @Test
    void contextLoads() {
        List<Admin> admins = adminmp.selectList(null);
        admins.forEach(System.out::println);
    }

    @Test
    void a(){
        String password = "123456";
        password = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        System.out.println(password);
    }

    @Test
    void b(){

    }

}
