package com.ognice.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;

import com.ognice.controller.common.JsonResult;
import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Org;
import com.ognice.service.IOrgService;

import java.util.Date;
/**
 * 部门 controller
 */
@Controller
@RequestMapping(value = "/admin/org", method = RequestMethod.GET)
public class AdminOrgController {
    @Resource
    private IOrgService orgService;
    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(HttpServletRequest request,ModelMap model, Org searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = orgService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        return "admin/org/page";
    }
	//新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Org record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            String msg = orgService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/admin/org";
            }
            model.addAttribute("msg", msg);
        }
        model.addAttribute("record", record);
        return "admin/org/form";
    }
        @RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
        public String save(HttpServletRequest request, HttpServletResponse response, Org record, @RequestParam(value="file",required=false) MultipartFile file) {
        request.setAttribute("record", record);
        if ("post".equals(request.getMethod().toLowerCase())) {
     if(file!=null){
        if (file.getSize() != 0) {
        String url = "";

        try {
        String staticPath =
        request.getSession().getServletContext().getRealPath("static/dist/img/");
        String fileName = file.getOriginalFilename();
        String[] filestr = fileName.split("\\.");
        String fileurl = System.currentTimeMillis() + "." + filestr[1];
        java.io.File targetFile = new java.io.File(staticPath, fileurl);
        file.transferTo(targetFile);
        url = "http://localhost:" + request.getLocalPort() +
        request.getSession().getServletContext().getContextPath() +
        "/static/dist/img/" + fileurl;
        } catch (Exception e) {
        e.printStackTrace();
        }
        }
}
        String msg = orgService.save(record);
        if (msg.equals("添加成功")) {
        return "redirect:/admin/org";
        }
        request.setAttribute("msg", msg);
        }
        return "admin/org/form";
        }


	//查看
    @RequestMapping(value = "/view")
    public String view(HttpServletRequest request,ModelMap model,Integer id) {
    	Org record = orgService.getOrgById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", false);
        return "admin/org/form";
    }
	//编辑
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request,ModelMap model,Integer id) {
    	Org record = orgService.getOrgById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", true);
        return "admin/org/form";
    }
    //更新
    @RequestMapping(value = "/update",method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Org record, ModelMap model, @RequestParam(value="file",required=false) MultipartFile file) {
         if ("post".equals(request.getMethod().toLowerCase())) {
            if(file!=null){
                if (file.getSize() != 0) {
                       String url = "";
               try {
                     String staticPath =
               request.getSession().getServletContext().getRealPath("static/dist/img/");
                     String fileName = file.getOriginalFilename();
                     String[] filestr = fileName.split("\\.");
                     String fileurl = System.currentTimeMillis() + "." + filestr[1];
                   java.io.File targetFile = new java.io.File(staticPath, fileurl);
                    file.transferTo(targetFile);
                  url = "http://localhost:" + request.getLocalPort() +
               request.getSession().getServletContext().getContextPath() +"/static/dist/img/" + fileurl;
             } catch (Exception e) {
                          e.printStackTrace();
                      }
               }
}}
       orgService.update(record);
        return "redirect:/admin/org";
    }
    //删除
    @RequestMapping(value = "/del")
    public String del(HttpServletRequest request,ModelMap model,Integer id) {
        orgService.delete(id);
        return "redirect:/admin/org";
    }
}
