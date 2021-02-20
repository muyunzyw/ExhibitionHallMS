package cn.ith.dao;

import cn.ith.domain.Role;
import cn.ith.domain.Sperson;
import cn.ith.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author muyun
 * @date 2020/4/2 - 16:56
 */
@Repository
public interface IUserDao {

    @Select("select * from user where username=#{username}")
    @Results(value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "id",property = "roles",javaType = List.class,many = @Many(select = "cn.ith.dao.IRoleDao.findRoleByUid")),
    })
    UserInfo findUserByName(String username);

    @Select("select * from user")
    List<UserInfo> findAll() throws Exception;

    //查询指定id的信息
    @Select("select * from user where id=#{id}")
    UserInfo findOneByid(Integer id) throws Exception;

    //删除通过id
    @Delete("delete from user where id=#{id}")
    void delUserById(Integer id);

    //保存信息
    @Insert("insert into user (username,password,email,phone) values(#{username},#{password},#{email},#{phone})")
    void saveUser(UserInfo userInfo);

    @Select("select * from role where id not in (select rid from users_role where uid=#{uid})")
    List<Role> findOtherRoles(Integer uid);

    @Insert("insert into users_role(uid,rid) values(#{uid},#{rid})")
    void addRoleToUser(@Param("uid") Integer uid, @Param("rid") Integer rid);
}
