package com.crmsystem.registration.service;

import com.crmsystem.registration.vo.UserDetails;

import javax.servlet.http.HttpServletRequest;

public interface IsLoggedInService {
    public UserDetails isLoggedIn();
}
