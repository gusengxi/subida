package com.subida.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
public class Admin {
    @TableField(value = "id")
    private int adminId;
    private String name;
    private String username;
    private String password;
    private String phone;
    private int status;
    private Date updateTime;
    private Date createTime;
}
