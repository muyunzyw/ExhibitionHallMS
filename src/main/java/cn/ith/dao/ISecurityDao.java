package cn.ith.dao;

import cn.ith.domain.Booth;
import cn.ith.domain.Security;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author muyun
 * @date 2020/3/27 - 18:19
 */

@Repository
public interface ISecurityDao {

    //查询所有信息
    @Select("select * from security")
    List<Security> findAll() throws Exception;

    //查询指定id的信息
    @Select("select * from security where id=#{id}")
    Security findOneByid(Integer id) throws Exception;

    //保存信息
    @Insert("insert into security (sid,eid,extent) values(#{sid},#{eid},#{extent})")
    void saveSecurity(Security security);

    //删除通过id
    @Delete("delete from security where id=#{id}")
    void delSeById(Integer id);

    //更新信息
    @Update("update security set sid=#{sid},eid=#{eid},extent=#{extent} where id=#{id}")
    void updateSecurity(Security security);
}
