package cn.ith.controller;

import cn.ith.domain.Booth;
import cn.ith.domain.Company;
import cn.ith.domain.Exhibit;
import cn.ith.service.IBoothService;
import cn.ith.service.IExhibitService;
import cn.ith.service.impl.BoothService;
import cn.ith.service.impl.ExhibitService;
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
 * @date 2020/3/31 - 16:53
 */
@Controller
@RequestMapping("/booth")
public class BoothController {

    @Autowired
    private IBoothService boothService;

    @Autowired
    private IExhibitService exhibitService;

    //查询所有
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Booth> All = boothService.findAll(page);
        //PageInfo是一个分页bean
        PageInfo pageInfo = new PageInfo(All);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("booth-list");
        return mv;
    }

    //保存单个
    @RequestMapping("/save.do")
    public String saveBooth(Booth booth){
        boothService.saveBooth(booth);
        return "redirect:findAll.do";
    }

    //删除指定id集合的数据集
    @RequestMapping("/del.do")
    @RolesAllowed("ADMIN")
    public String delBooth( String[] ids){
        int[] array = Arrays.asList(ids).stream().mapToInt(Integer::parseInt).toArray();
        boothService.delBoByArr(IntUntils.intToInteger(array));
        return "redirect:findAll.do";
    }

    //改变数据库中的信息
    @RequestMapping("/update.do")
    @RolesAllowed("ADMIN")
    public String updateBooth(Booth booth){
        boothService.updateBooth(booth);
        return "redirect:findAll.do";
    }

    @RequestMapping("/seach.do")
    public ModelAndView findOneById(String seach_id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Integer id = Integer.parseInt(seach_id);
        Booth ex = boothService.findOneById(id);
        mv.addObject("result",ex);
        mv.setViewName("booth-seach");
        return mv;
    }

    @RequestMapping("/allId.do")
    public @ResponseBody
    List<Exhibit> findAllEId() throws Exception {
        List<Exhibit> exhibits = exhibitService.findAllNoPage();
        return exhibits;

    }


}
