package com.youzhihua.bs.service;

import com.youzhihua.bs.dao.TUserMapper;
import com.youzhihua.bs.dao.entity.TUser;
import com.youzhihua.bs.dto.UserLoginDTO;
import com.youzhihua.bs.utils.Result;
import com.youzhihua.bs.utils.ResultUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private TUserMapper tUserMapper;



    public Result userLogin(UserLoginDTO userLoginDTO){
        //正确的code
        String validateCode = (String) session.getAttribute("code");

        String checkCode = userLoginDTO.getCheckCode();

        if(StringUtils.isNotBlank(checkCode) && checkCode.equals(validateCode)){
            //验证码正确
            TUser tUser = tUserMapper.selectByName(userLoginDTO.getUsername());
            if(tUser == null){
                return ResultUtils.error("","用户名或者密码错误");
            }else if(!tUser.getPassword().equals(userLoginDTO.getPassword())){
                return ResultUtils.error("","用户名或者密码错误");
            }
            return ResultUtils.success(tUser);
        }else {
            return ResultUtils.error("","验证码错误");
        }

    }

    //用户注销
    public void loginOut(){
        session.removeAttribute("user");
        session.removeAttribute("message");
    }

    public void editPew(TUser user) {
        TUser tuser = (TUser) session.getAttribute("user");
        tuser.setPassword(user.getPassword());
        tUserMapper.updatePwd(tuser);
    }
}
