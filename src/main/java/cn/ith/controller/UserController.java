package cn.ith.controller;

import cn.ith.domain.Role;
import cn.ith.domain.Sperson;
import cn.ith.domain.UserInfo;
import cn.ith.service.IUserService;
import cn.ith.utils.IntUntils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;

/**
 * @author muyun
 * @date 2020/4/2 - 19:30
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    //查询所有
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> All = userService.findAll();
        mv.addObject("pageInfo",All);
        mv.setViewName("user-list");
        return mv;
    }

    //保存单个
    @RequestMapping("/save.do")
    @RolesAllowed("ADMIN")
    public String saveUser(UserInfo userInfo){
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        userService.saveUser(userInfo);
        return "redirect:findAll.do";
    }

    //删除指定id集合的数据集
    @RequestMapping("/del.do")
    @RolesAllowed("ADMIN")
    public String delSperson( String[] ids){
        int[] array = Arrays.asList(ids).stream().mapToInt(Integer::parseInt).toArray();
        userService.delSpByArr(IntUntils.intToInteger(array));
        return "redirect:findAll.do";
    }

    @RequestMapping("/allrole.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findRole(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Integer uid = Integer.parseInt(id);
        UserInfo user = userService.findOneByid(uid);
        List<Role> roles = userService.findOtherRoles(uid);
        mv.addObject("user",user);
        mv.addObject("roleList",roles);
        mv.setViewName("user-role-add");
        return mv;
    }

    //给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    @RolesAllowed("ADMIN")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds) {
        Integer uid = Integer.parseInt(userId);
        int[] array = Arrays.asList(roleIds).stream().mapToInt(Integer::parseInt).toArray();
        userService.addRoleToUser(uid, IntUntils.intToInteger(array));
        return "redirect:findAll.do";
    }
}
