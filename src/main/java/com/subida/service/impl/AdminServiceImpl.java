package com.subida.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.subida.entity.Admin;
import com.subida.mapper.AdminMapper;
import com.subida.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
}
