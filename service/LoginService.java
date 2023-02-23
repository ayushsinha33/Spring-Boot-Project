package com.crmsystem.registration.service;

import com.crmsystem.registration.entity.UserRegistry;
import com.crmsystem.registration.vo.UserDetails;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
    public boolean login(String email, String password, int captchaAnswer, HttpServletRequest request);

    public void logout(HttpServletRequest request);
}
