package cn.ith.controller;

import cn.ith.domain.Exhibit;
import cn.ith.service.IExhibitService;
import cn.ith.utils.IntUntils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;

/**
 * @author muyun
 * @date 2020/3/27 - 16:14
 */
@Controller
@RequestMapping("/exhibit")
public class ExhibitController {

    @Autowired
    private IExhibitService exhibitService;

    //查询所有
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Exhibit> exAll = exhibitService.findAll(page);
        //PageInfo是一个分页bean
        PageInfo pageInfo = new PageInfo(exAll);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("exhibit-list");
        return mv;
    }

    //保存单个
    @RequestMapping("/save.do")
    public String saveExhibit(Exhibit exhibit){
        exhibitService.saveExhibit(exhibit);
        return "redirect:findAll.do";
    }

    //删除指定id集合的数据集
    @RequestMapping("/del.do")
    @RolesAllowed("ADMIN")
    public String delExhibit( String[] ids){
        int[] array = Arrays.asList(ids).stream().mapToInt(Integer::parseInt).toArray();
        exhibitService.delExByArr(IntUntils.intToInteger(array));
        return "redirect:findAll.do";
    }

    //改变数据库中的信息
    @RequestMapping("/update.do")
    @RolesAllowed("ADMIN")
    public String updateExhibit(Exhibit exhibit){
        exhibitService.updateExhibit(exhibit);
        return "redirect:findAll.do";
    }

    @RequestMapping("/seach.do")
    public ModelAndView findOneById(String seach_id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Integer id = Integer.parseInt(seach_id);
        Exhibit ex = exhibitService.findOneById(id);
        mv.addObject("exhibit_result",ex);
        mv.setViewName("exhibit-seach");
        return mv;
    }

    @RequestMapping("/show.do")
    public ModelAndView showExhibit(String id){
        ModelAndView mv = new ModelAndView();
        Integer eid = Integer.parseInt(id);
        Exhibit ex = exhibitService.findOneByidForShow(eid);
        mv.addObject("showRe",ex);
        mv.setViewName("exhibit-show");
        return mv;
    }
}
