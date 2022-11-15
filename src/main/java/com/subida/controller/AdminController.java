package com.subida.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.subida.common.R;
import com.subida.entity.Admin;
import com.subida.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.One;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@Slf4j
@RestController
@RequestMapping(value = "/Admin")
public class AdminController{

    @Autowired
    private AdminService adminService;
    //登录
    @PostMapping("/login")
    public R<Admin> login(HttpServletRequest request, @RequestBody Admin admin){
        //加密密码
        String password = admin.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //验证账号是否存在
        LambdaQueryWrapper<Admin> adminLambdaQueryWrapper = new LambdaQueryWrapper<>();
        adminLambdaQueryWrapper.eq(Admin::getUsername,admin.getUsername());
        Admin one = adminService.getOne(adminLambdaQueryWrapper);
        //账号存在与否
        if (one == null){
            return R.error("账号不存在");
        }

        //密码是否正确
        if (!one.getPassword().equals(password)){
            return R.error("密码不存在");
        }

        //账号是否封禁
        if (! (one.getStatus() == 0) ){
            return R.error("账号已被冻结，请联系管理员");
        }

        //登录成功
        request.getSession().setAttribute("admin", one.getAdminId());
        return R.success(one);
    }
}
