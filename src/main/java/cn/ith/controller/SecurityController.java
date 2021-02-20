package cn.ith.controller;

import cn.ith.domain.*;
import cn.ith.service.IExhibitService;
import cn.ith.service.ISecurityService;
import cn.ith.service.ISpersonService;
import cn.ith.utils.IntUntils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;

/**
 * @author muyun
 * @date 2020/3/31 - 21:17
 */
@Controller
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private IExhibitService exhibitService;

    @Autowired
    private ISpersonService spersonService;

    //查询所有
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Security> All = securityService.findAll(page);
        //PageInfo是一个分页bean
        PageInfo pageInfo = new PageInfo(All);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("security-list");
        return mv;
    }

    //保存单个
    @RequestMapping("/save.do")
    public String saveSecurity(Security security){
        System.out.println(security);
        securityService.saveSecurity(security);
        return "redirect:findAll.do";
    }

    //删除指定id集合的数据集
    @RequestMapping("/del.do")
    @RolesAllowed("ADMIN")
    public String delSecurity( String[] ids){
        int[] array = Arrays.asList(ids).stream().mapToInt(Integer::parseInt).toArray();
        securityService.delSeByArr(IntUntils.intToInteger(array));
        return "redirect:findAll.do";
    }

    //改变数据库中的信息
    @RequestMapping("/update.do")
    @RolesAllowed("ADMIN")
    public String updateSecurity(Security security){
        securityService.updateSecurity(security);
        return "redirect:findAll.do";
    }

    //查询单个
    @RequestMapping("/seach.do")
    public ModelAndView findOneById(String seach_id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Integer id = Integer.parseInt(seach_id);
        Security re = securityService.findOneById(id);
        mv.addObject("result",re);
        mv.setViewName("security-seach");
        return mv;
    }

    @RequestMapping("/allExId.do")
    public @ResponseBody
    List<Exhibit> findExAllId() throws Exception {
        List<Exhibit> exhibits = exhibitService.findAllNoPage();
        return exhibits;
    }

    @RequestMapping("/allSpId.do")
    public @ResponseBody
    List<Sperson> findSpAllId() throws Exception {
        List<Sperson> spersons = spersonService.findAllNoPage();
        return spersons;
    }

}
