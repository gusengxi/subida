package com.subida.subida;

import com.subida.entity.Admin;
import com.subida.mapper.AdminMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SubidaApplicationTests {

    @Autowired
    private AdminMapper admin;
    @Test
    void contextLoads() {
        List<Admin> admins = admin.selectList(null);
        admins.forEach(System.out::println);
    }

}
