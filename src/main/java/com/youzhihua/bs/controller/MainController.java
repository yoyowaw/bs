package com.youzhihua.bs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @RequestMapping("/page_base_region.action")
    public String region(){
        return "/WEB-INF/pages/base/region";
    }

    @RequestMapping("/page_common_home")
    public String main(){
        return "/WEB-INF/pages/common/home";
    }

    @RequestMapping("page_base_staff")
    public String staff(){
        return "/WEB-INF/pages/base/staff";
    }

    @RequestMapping("/page_base_subarea.action")
    public String subarea(){
        return "/WEB-INF/pages/base/subarea";
    }
    @RequestMapping("/page_base_decidedzone.action")
    public String decidedzone(){
        return "/WEB-INF/pages/base/decidedzone";
    }

    @RequestMapping("/page_qupai_noticebill_add.action")
    public String notice(){
        return "/WEB-INF/pages/qupai/noticebill_add";
    }

    @RequestMapping("/page_qupai_quickworkorder.action")
    public String quickworkorder(){
        return "/WEB-INF/pages/qupai/quickworkorder";
    }

    @RequestMapping("/page_qupai_diaodu.action")
    public String diaodu(){
        return "/WEB-INF/pages/qupai/diaodu";
    }

    @RequestMapping("/page_portal_gonggao.action?_=1555595475024")
    public String gongao(String _){
        return "/WEB-INF/portal/gongao";
    }

    @RequestMapping("/page_portal_daiban.action")
    public String daiban(){
        return "/WEB-INF/portal/daiban";
    }

    @RequestMapping("/page_portal_yujing.action")
    public String yujing(){
        return "/WEB-INF/portal/yujing";
    }

    @RequestMapping("/page_portal_bug.action")
    public String bug(){
        return "/WEB-INF/portal/bug";
    }

}
