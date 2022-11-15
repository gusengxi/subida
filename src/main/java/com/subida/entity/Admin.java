package com.subida.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private String name;
    private String username;
    private String password;
    private String phone;
    private int status;

    private Date updateTime;
    private Date createTime;
}
