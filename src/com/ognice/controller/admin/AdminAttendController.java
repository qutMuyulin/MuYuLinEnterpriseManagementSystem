package com.ognice.controller.admin;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Attend;
import com.ognice.service.IAttendService;
import com.ognice.service.IStaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
/**
 * 考勤 controller
 */
@Controller
@RequestMapping(value = "/admin/attend", method = RequestMethod.GET)
public class AdminAttendController {
    @Resource
    private IAttendService attendService;
        @Resource
        private IStaffService staffService;
    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(HttpServletRequest request,ModelMap model, Attend searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = attendService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        return "admin/attend/page";
    }
	//新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Attend record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            record.setCreated(new Date());
            String msg = attendService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/admin/attend";
            }
            model.addAttribute("msg", msg);
        }
                if(record.getStaffid()!=null){
                record.setStaffname(staffService.getStaffById(record.getStaffid()).getName());
            }
            model.addAttribute("staffs", staffService.all());
        model.addAttribute("record", record);
        return "admin/attend/form";
    }
        @RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
        public String save(HttpServletRequest request, HttpServletResponse response, Attend record, @RequestParam(value="file",required=false) MultipartFile file) {
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
            record.setCreated(new Date());
    if(record.getStaffid()!=null){
    record.setStaffname(staffService.getStaffById(record.getStaffid()).getName());
    }
        String msg = attendService.save(record);
        if (msg.equals("添加成功")) {
        return "redirect:/admin/attend";
        }
        request.setAttribute("msg", msg);
        }
        return "admin/attend/form";
        }


	//查看
    @RequestMapping(value = "/view")
    public String view(HttpServletRequest request,ModelMap model,Integer id) {
    	Attend record = attendService.getAttendById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", false);
            model.addAttribute("staffs", staffService.all());
        return "admin/attend/form";
    }
	//编辑
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request,ModelMap model,Integer id) {
    	Attend record = attendService.getAttendById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", true);
            model.addAttribute("staffs", staffService.all());
        return "admin/attend/form";
    }
    //更新
    @RequestMapping(value = "/update",method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Attend record, ModelMap model, @RequestParam(value="file",required=false) MultipartFile file) {
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
           }
      }
        if(record.getStaffid()!=null){
          record.setStaffname(staffService.getStaffById(record.getStaffid()).getName());
    }
              attendService.update(record);
        return "redirect:/admin/attend";
    }
    //删除
    @RequestMapping(value = "/del")
    public String del(HttpServletRequest request,ModelMap model,Integer id) {
        attendService.delete(id);
        return "redirect:/admin/attend";
    }
}
