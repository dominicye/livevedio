package com.ways.live.controller;

import com.ways.live.dto.UserModel;
import com.ways.live.model.User;
import com.ways.live.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserModel login(@RequestParam String cellPhone, @RequestParam String password, HttpServletRequest request, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");
        User currentUser = (User)request.getSession().getAttribute("currentUser");
        UserModel userModel = new UserModel();
        if(currentUser != null)
        {
            buildUserModel(currentUser,userModel);
            return userModel;
        }

        User user = userService.getUser(cellPhone, password);
        if(user != null)
        {
            request.getSession().setAttribute("currentUser", user);
            buildUserModel(user,userModel);
            return userModel;
        }

        return userModel;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(@RequestParam String cellPhone, @RequestParam String password,@RequestParam String userName,  HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
        User user = null;
        try {
            user = userService.createUser(cellPhone,password,userName);
        }
        catch (Exception e)
        {
            user = new User();
            System.out.println("create user failed");
            e.printStackTrace();
        }

        return user;
    }

    private UserModel buildUserModel(User user, UserModel userModel)
    {
        userModel.setId(user.getId());
        userModel.setCellPhone(user.getCellPhone());
        userModel.setName(user.getName());
        userModel.setPassword(user.getPassword());
        userModel.setRegisterTime(user.getRegisterTime()==null?"":user.getRegisterTime().toString());
        userModel.setType(user.getType());
        userModel.setVerifyCode(user.getVerifyCode());

        return userModel;
    }

}
