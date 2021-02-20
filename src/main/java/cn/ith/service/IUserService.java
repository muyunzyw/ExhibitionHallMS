package cn.ith.service;

import cn.ith.domain.Role;
import cn.ith.domain.Sperson;
import cn.ith.domain.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author muyun
 * @date 2020/4/2 - 16:36
 */
public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll() throws Exception;

    UserInfo findOneByid(Integer id) throws Exception;

    void delUserById(Integer id);

    void saveUser(UserInfo userInfo);

    void delSpByArr(Integer[] ids);

    List<Role> findOtherRoles(Integer uid);

    void addRoleToUser(Integer uid, Integer[] rids);
}
