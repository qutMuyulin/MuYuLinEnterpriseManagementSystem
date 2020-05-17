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
import com.ognice.domain.Cangkudetail;
import com.ognice.service.ICangkudetailService;
import com.ognice.service.ICangkuService ;

import java.util.Date;
/**
 * 库存 controller
 */
@Controller
@RequestMapping(value = "/admin/cangkudetail", method = RequestMethod.GET)
public class AdminCangkudetailController {
    @Resource
    private ICangkudetailService cangkudetailService;
        @Resource
        private ICangkuService cangkuService;
    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(HttpServletRequest request,ModelMap model, Cangkudetail searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = cangkudetailService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        return "admin/cangkudetail/page";
    }
	//新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Cangkudetail record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            String msg = cangkudetailService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/admin/cangkudetail";
            }
            model.addAttribute("msg", msg);
        }
                if(record.getCangkuid()!=null){
                record.setCangkuname(cangkuService.getCangkuById(record.getCangkuid()).getName());
            }
            model.addAttribute("cangkus", cangkuService.all());
        model.addAttribute("record", record);
        return "admin/cangkudetail/form";
    }
        @RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
        public String save(HttpServletRequest request, HttpServletResponse response, Cangkudetail record, @RequestParam(value="file",required=false) MultipartFile file) {
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
    if(record.getCangkuid()!=null){
    record.setCangkuname(cangkuService.getCangkuById(record.getCangkuid()).getName());
    }
        String msg = cangkudetailService.save(record);
        if (msg.equals("添加成功")) {
        return "redirect:/admin/cangkudetail";
        }
        request.setAttribute("msg", msg);
        }
        return "admin/cangkudetail/form";
        }


	//查看
    @RequestMapping(value = "/view")
    public String view(HttpServletRequest request,ModelMap model,Integer id) {
    	Cangkudetail record = cangkudetailService.getCangkudetailById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", false);
            model.addAttribute("cangkus", cangkuService.all());
        return "admin/cangkudetail/form";
    }
	//编辑
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request,ModelMap model,Integer id) {
    	Cangkudetail record = cangkudetailService.getCangkudetailById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", true);
            model.addAttribute("cangkus", cangkuService.all());
        return "admin/cangkudetail/form";
    }
    //更新
    @RequestMapping(value = "/update",method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, Cangkudetail record, ModelMap model, @RequestParam(value="file",required=false) MultipartFile file) {
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
    if(record.getCangkuid()!=null){
    record.setCangkuname(cangkuService.getCangkuById(record.getCangkuid()).getName());
    }
cangkudetailService.update(record);
        return "redirect:/admin/cangkudetail";
    }
    //删除
    @RequestMapping(value = "/del")
    public String del(HttpServletRequest request,ModelMap model,Integer id) {
        cangkudetailService.delete(id);
        return "redirect:/admin/cangkudetail";
    }
}
