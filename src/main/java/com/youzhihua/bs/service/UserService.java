package com.youzhihua.bs.service;

import com.youzhihua.bs.dao.TRoleMapper;
import com.youzhihua.bs.dao.TUserMapper;
import com.youzhihua.bs.dao.TUserRoleMapper;
import com.youzhihua.bs.dao.entity.TRole;
import com.youzhihua.bs.dao.entity.TUser;
import com.youzhihua.bs.dao.entity.TUserRole;
import com.youzhihua.bs.dto.UserLoginDTO;
import com.youzhihua.bs.utils.Result;
import com.youzhihua.bs.utils.ResultUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private TUserMapper tUserMapper;

    @Autowired
    private TUserRoleMapper userRoleMapper;
    @Autowired
    private TRoleMapper tRoleMapper;



    public Result<UserLoginDTO> userLogin(UserLoginDTO userLoginDTO){
        //正确的code
        String validateCode = (String) session.getAttribute("code");

        String checkCode = userLoginDTO.getCheckCode();

        if(true){
            //验证码正确
            TUser tUser = tUserMapper.selectByName(userLoginDTO.getUsername());
            if(tUser == null){
                return ResultUtils.error("","用户名或者密码错误");
            }else if(!tUser.getPassword().equals(userLoginDTO.getPassword())){
                return ResultUtils.error("","用户名或者密码错误");
            }
            UserLoginDTO dto = new UserLoginDTO();
            BeanUtils.copyProperties(userLoginDTO,dto);
            dto.setUserId(tUser.getId());
            List<TUserRole> tUserRoles = userRoleMapper.selectByUserId(Integer.valueOf(tUser.getId()));
            TRole tRole = tRoleMapper.selectById(tUserRoles.get(0).getRoleId());
            dto.setName(tRole.getName());
            dto.setRoleId(tRole.getRoleId());

            return ResultUtils.success(dto);
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

    public void add(TUser user) {
        tUserMapper.insert(user);
        TUserRole userRole = new TUserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(user.getRoleId());
        userRoleMapper.insert(userRole);
    }
}
