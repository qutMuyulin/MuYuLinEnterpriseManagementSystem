package com.ognice.controller.admin;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Cangkudetail;
import com.ognice.domain.Inorder;
import com.ognice.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;

/**
 * 采购 controller
 */
@Controller
@RequestMapping(value = "/admin/inorder", method = RequestMethod.GET)
public class AdminInorderController {
    @Resource
    private IInorderService inorderService;
    @Resource
    private ICangkuService cangkuService;
    @Resource
    private ICangkudetailService cangkudetailService;
    @Resource
    private ICustomerService customerService;
    @Resource
    private IMaterService materService;
    /**
     * 列表
     */
    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(HttpServletRequest request, ModelMap model, Inorder searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = inorderService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        return "admin/inorder/page";
    }
    //新增
    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public String add(HttpServletRequest request, Inorder record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            record.setCreated(new Date());
            String msg = inorderService.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/admin/inorder";
            }
            model.addAttribute("msg", msg);
        }
        if (record.getCangkuid() != null) {
            record.setCangkuname(cangkuService.getCangkuById(record.getCangkuid()).getName());
        }
        model.addAttribute("cangkus", cangkuService.all());
        if (record.getCustomerid() != null) {
            record.setCustomername(customerService.getCustomerById(record.getCustomerid()).getName());
        }
        model.addAttribute("customers", customerService.all());
        model.addAttribute("maters", materService.all());
        model.addAttribute("record", record);
        return "admin/inorder/form";
    }
    @RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
    public String save(HttpServletRequest request, HttpServletResponse response, Inorder record, @RequestParam(value = "file", required = false) MultipartFile file) {
        request.setAttribute("record", record);
        if ("post".equals(request.getMethod().toLowerCase())) {
            if (file != null) {
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
            if (record.getCangkuid() != null) {
                record.setCangkuname(cangkuService.getCangkuById(record.getCangkuid()).getName());
            }
            if (record.getCustomerid() != null) {
                record.setCustomername(customerService.getCustomerById(record.getCustomerid()).getName());
            }
            record.setName(materService.getMaterById(record.getMateridd()).getName());
            if(record.getCreated()!=null){
                Calendar now = Calendar.getInstance();
                now.setTime(record.getCreated());
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH)+1;
                record.setYear(year);
                record.setMonth(month);
            }
            String msg = inorderService.save(record);
            if (msg.equals("添加成功")) {

                Cangkudetail ckd = cangkudetailService.getDetail(record.getCangkuid(),record.getMateridd());
                if(ckd!=null){
                    ckd.setCount(ckd.getCount()+record.getCount());
                    cangkudetailService.update(ckd);
                }else{
                    ckd=new Cangkudetail();
                    ckd.setCangkuid(record.getCangkuid());
                    ckd.setCangkuname(record.getCangkuname());
                    ckd.setMateridd(record.getMateridd());
                    ckd.setName(record.getName());
                    ckd.setCount(record.getCount());
                    cangkudetailService.save(ckd);
                }
                return "redirect:/admin/inorder";
            }
            request.setAttribute("msg", msg);
        }
        return "admin/inorder/form";
    }
    //查看
    @RequestMapping(value = "/view")
    public String view(HttpServletRequest request, ModelMap model, Integer id) {
        Inorder record = inorderService.getInorderById(id);
        model.addAttribute("record", record);
        model.addAttribute("edit", false);
        model.addAttribute("cangkus", cangkuService.all());
        model.addAttribute("customers", customerService.all());
        return "admin/inorder/form";
    }
    //编辑
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request, ModelMap model, Integer id) {
        Inorder record = inorderService.getInorderById(id);
        model.addAttribute("record", record);
        model.addAttribute("edit", true);
        model.addAttribute("cangkus", cangkuService.all());
        model.addAttribute("customers", customerService.all());
        return "admin/inorder/form";
    }
    //更新
    @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
    public String update(HttpServletRequest request, Inorder record, ModelMap model, @RequestParam(value = "file", required = false) MultipartFile file) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            if (file != null) {
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
        }
        if (record.getCangkuid() != null) {
            record.setCangkuname(cangkuService.getCangkuById(record.getCangkuid()).getName());
        }
        if (record.getCustomerid() != null) {
            record.setCustomername(customerService.getCustomerById(record.getCustomerid()).getName());
        }
        inorderService.update(record);
        return "redirect:/admin/inorder";
    }
    //删除
    @RequestMapping(value = "/del")
    public String del(HttpServletRequest request, ModelMap model, Integer id) {
        inorderService.delete(id);
        return "redirect:/admin/inorder";
    }
}
