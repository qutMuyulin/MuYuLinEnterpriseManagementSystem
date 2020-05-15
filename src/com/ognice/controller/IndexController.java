
package com.ognice.controller;
import com.ognice.domain.User;
import com.ognice.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    @Resource
    private IUserService userservice;

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "admin/demo";
    }
 /**
     * 前台首页
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String preindex(ModelMap model) {
      return "redirect:/admin";
    }
   
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/";
    }

    /**
     * 前台退出
     */
    @RequestMapping(value = "/index/logout")
    public String logout2(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("indexUser");
        return "redirect:/index";
    }
 /**
     * 后台首页
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String index(ModelMap model) {
        return "admin/index";
    }
    /**
     * 后台登录
     */
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("u");
        String psw = request.getParameter("p");
        User u = userservice.login(username, psw);
        if (null == u) {
            if(request.getMethod().equals("POST")) {
                request.setAttribute("msg", "账号或密码错误");
            }
            return "admin/login";
        }
        if (u.getStatus().equals(1)) {
            request.setAttribute("msg", "账号已禁用");
            return "admin/login";
        }
        request.getSession().setAttribute("loginUser", u);
        return "redirect:/admin";
    }
    /**
     * 后台退出
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("loginUser");
        return "redirect:/admin";
    }
}
