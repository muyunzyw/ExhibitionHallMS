package cn.ith.controller;

import cn.ith.domain.Company;
import cn.ith.domain.Exhibit;
import cn.ith.service.ICompanyService;
import cn.ith.service.IExhibitService;
import cn.ith.utils.IntUntils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author muyun
 * @date 2020/3/30 - 17:15
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private IExhibitService exhibitService;

    //查询所有
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Company> exAll = companyService.findAll(page);
        //PageInfo是一个分页bean
        PageInfo pageInfo = new PageInfo(exAll);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("company-list");
        return mv;
    }

    //保存单个
    @RequestMapping("/save.do")
    public String saveCompany(Company company){
        companyService.saveCompany(company);
        return "redirect:findAll.do";
    }

    //删除指定id集合的数据集
    @RequestMapping("/del.do")
    @RolesAllowed("ADMIN")
    public String delCompany( String[] ids){
        int[] array = Arrays.asList(ids).stream().mapToInt(Integer::parseInt).toArray();
        companyService.delComByArr(IntUntils.intToInteger(array));
        return "redirect:findAll.do";
    }

    //改变数据库中的信息
    @RequestMapping("/update.do")
    @RolesAllowed("ADMIN")
    public String updateCompany(Company company){
        companyService.updateCompany(company);
        return "redirect:findAll.do";
    }

    //查询单个
    @RequestMapping("/seach.do")
    public ModelAndView findOneById(String seach_id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Integer id = Integer.parseInt(seach_id);
        Company ex = companyService.findOneById(id);
        mv.addObject("company_result",ex);
        mv.setViewName("company-seach");
        return mv;
    }

    @RequestMapping("/allId.do")
    public @ResponseBody List<Exhibit> findAllEId() throws Exception {
        List<Exhibit> exhibits = exhibitService.findAllNoPage();
        return exhibits;

    }

    @RequestMapping("/show.do")
    public ModelAndView showExhibit(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Integer eid = Integer.parseInt(id);
        Company ex = companyService.findOneByIdForShow(eid);
        mv.addObject("showRe",ex);
        mv.setViewName("company-show");
        return mv;
    }
}
