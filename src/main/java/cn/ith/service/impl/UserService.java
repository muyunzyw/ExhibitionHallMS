package cn.ith.service.impl;

import cn.ith.dao.IUserDao;
import cn.ith.domain.Role;
import cn.ith.domain.UserInfo;
import cn.ith.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muyun
 * @date 2020/4/2 - 16:37
 */
@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findUserByName(username);
        User user = new User(userInfo.getUsername(),userInfo.getPassword(), getAuthority(userInfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }


    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public UserInfo findOneByid(Integer id) throws Exception {
        return userDao.findOneByid(id);
    }

    @Override
    public void delUserById(Integer id) {
        userDao.delUserById(id);
    }

    @Override
    public void delSpByArr(Integer[] ids) {
        for(int i=0;i<ids.length;i++){
            userDao.delUserById(ids[i]);
        }
    }

    @Override
    public List<Role> findOtherRoles(Integer uid) {
        return userDao.findOtherRoles(uid);
    }

    @Override
    public void addRoleToUser(Integer uid, Integer[] rids) {
        for(Integer rid:rids){
            userDao.addRoleToUser(uid,rid);
        }
    }


    @Override
    public void saveUser(UserInfo userInfo) {
        userDao.saveUser(userInfo);
    }


}
