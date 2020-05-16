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
import com.ognice.domain.Staff;
import com.ognice.service.IStaffService;
import com.ognice.service.IJobtypeService ;
import com.ognice.service.IOrgService ;

import java.util.Date;
/**
 * 员工 controller
 */
@Controller
@RequestMapping(value = "/admin/staff", method = RequestMethod.GET)
public class AdminStaffController {
    @Resource
    private IStaffService staffService;
        @Resource
        private IJobtypeService jobtypeService;
        @Resource
        private IOrgService orgService;
    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(HttpServletRequest request,ModelMap model, Staff searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = staffService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        return "admin/staff/page";
    }
	//新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Staff record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            String msg = staffService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/admin/staff";
            }
            model.addAttribute("msg", msg);
        }
                if(record.getJobtypeid()!=null){
                record.setJobtypename(jobtypeService.getJobtypeById(record.getJobtypeid()).getName());
            }
            model.addAttribute("jobtypes", jobtypeService.all());
                if(record.getOrgid()!=null){
                record.setOrgname(orgService.getOrgById(record.getOrgid()).getName());
            }
            model.addAttribute("orgs", orgService.all());
        model.addAttribute("record", record);
        return "admin/staff/form";
    }
        @RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
        public String save(HttpServletRequest request, HttpServletResponse response, Staff record, @RequestParam(value="file",required=false) MultipartFile file) {
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
            record.setPicurl(url);
        }
}
    if(record.getJobtypeid()!=null){
    record.setJobtypename(jobtypeService.getJobtypeById(record.getJobtypeid()).getName());
    }
    if(record.getOrgid()!=null){
    record.setOrgname(orgService.getOrgById(record.getOrgid()).getName());
    }
        String msg = staffService.save(record);
        if (msg.equals("添加成功")) {
        return "redirect:/admin/staff";
        }
        request.setAttribute("msg", msg);
        }
        return "admin/staff/form";
        }
	//查看
    @RequestMapping(value = "/view")
    public String view(HttpServletRequest request,ModelMap model,Integer id) {
    	Staff record = staffService.getStaffById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", false);
            model.addAttribute("jobtypes", jobtypeService.all());
            model.addAttribute("orgs", orgService.all());
        return "admin/staff/form";
    }
	//编辑
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request,ModelMap model,Integer id) {
    	Staff record = staffService.getStaffById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", true);
            model.addAttribute("jobtypes", jobtypeService.all());
            model.addAttribute("orgs", orgService.all());
        return "admin/staff/form";
    }
    //更新
    @RequestMapping(value = "/update",method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Staff record, ModelMap model, @RequestParam(value="file",required=false) MultipartFile file) {
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
      record.setPicurl(url);
        }
}}
    if(record.getJobtypeid()!=null){
    record.setJobtypename(jobtypeService.getJobtypeById(record.getJobtypeid()).getName());
    }
    if(record.getOrgid()!=null){
    record.setOrgname(orgService.getOrgById(record.getOrgid()).getName());
    }
             staffService.update(record);
        return "redirect:/admin/staff";
    }
    //删除
    @RequestMapping(value = "/del")
    public String del(HttpServletRequest request,ModelMap model,Integer id) {
        staffService.delete(id);
        return "redirect:/admin/staff";
    }
}
