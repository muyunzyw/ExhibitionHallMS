package cn.ith.controller;

import cn.ith.domain.Booth;
import cn.ith.domain.Exhibit;
import cn.ith.domain.Sperson;
import cn.ith.service.ISpersonService;
import cn.ith.service.impl.SpersonService;
import cn.ith.utils.IntUntils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;

/**
 * @author muyun
 * @date 2020/3/31 - 20:17
 */
@Controller
@RequestMapping("/sperson")
public class SpersonController {

    @Autowired
    private ISpersonService spersonService;

    //查询所有
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Sperson> All = spersonService.findAll(page);
        //PageInfo是一个分页bean
        PageInfo pageInfo = new PageInfo(All);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("sperson-list");
        return mv;
    }

    //保存单个
    @RequestMapping("/save.do")
    public String saveSperson(Sperson sperson){
        spersonService.saveSperson(sperson);
        return "redirect:findAll.do";
    }

    //删除指定id集合的数据集
    @RequestMapping("/del.do")
    @RolesAllowed("ADMIN")
    public String delSperson( String[] ids){
        int[] array = Arrays.asList(ids).stream().mapToInt(Integer::parseInt).toArray();
        spersonService.delSpByArr(IntUntils.intToInteger(array));
        return "redirect:findAll.do";
    }

    //改变数据库中的信息
    @RequestMapping("/update.do")
    @RolesAllowed("ADMIN")
    public String updateSperson(Sperson sperson){
        spersonService.updateSperson(sperson);
        return "redirect:findAll.do";
    }

    @RequestMapping("/seach.do")
    public ModelAndView findOneById(String seach_id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Integer id = Integer.parseInt(seach_id);
        Sperson sp = spersonService.findOneById(id);
        mv.addObject("result",sp);
        mv.setViewName("sperson-seach");
        return mv;
    }

}
