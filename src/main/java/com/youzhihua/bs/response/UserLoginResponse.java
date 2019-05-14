package com.youzhihua.bs.response;

import com.youzhihua.bs.dao.entity.TResource;
import com.youzhihua.bs.dto.UserLoginDTO;
import io.swagger.annotations.Api;
import lombok.Data;

import java.util.List;

/**
 * @Author youzhihua
 * @Date 2019/5/14 12:56
 */
@Data
@Api("登录接口返回参数")
public class UserLoginResponse {

    private UserLoginDTO userLoginDTO;

    private List<TResource> resources;
}
