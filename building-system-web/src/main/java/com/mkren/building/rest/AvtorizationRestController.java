package com.mkren.building.rest;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkren.building.bean.UserBean;

@CrossOrigin
@RestController
public class AvtorizationRestController extends AbstractRestController {

    @GetMapping(value = "/valid-user-rest")
    public UserBean getValidUser() {

	Authentication auth = SecurityContextHolder.getContext()
	                                           .getAuthentication();
	String login = auth.getName();

	UserBean validUser = avtorizationService.loadUserBeanByLogin(login);

	return validUser;
    }

    @GetMapping(value = "/all-users-rest")
    public List<UserBean> restUser() {
	return avtorizationService.loadAllUserBean();
    }
}