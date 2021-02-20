package cn.ith.dao;

import cn.ith.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author muyun
 * @date 2020/4/2 - 17:54
 */
@Repository
public interface IRoleDao {

    @Select("select * from role where id in (select rid from users_role where uid=#{uid})")
    public List<Role> findRoleByUid(String uid);
}
