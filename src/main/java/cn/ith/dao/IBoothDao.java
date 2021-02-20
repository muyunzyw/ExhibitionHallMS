package cn.ith.dao;

import cn.ith.domain.Booth;
import cn.ith.domain.Product;
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
public interface IBoothDao {

    //查询所有信息
    @Select("select * from booth")
    List<Booth> findAll() throws Exception;

    //查询指定id的信息
    @Select("select * from booth where id=#{id}")
    Booth findOneByid(Integer id) throws Exception;

    //保存信息
    @Insert("insert into booth (eid,bName,place) values(#{eid},#{bName},#{place})")
    void saveBooth(Booth booth);

    //删除通过id
    @Delete("delete from booth where id=#{id}")
    void delBoById(Integer id);

    //更新信息
    @Update("update booth set eid=#{eid},bName=#{bName},place=#{place} where id=#{id}")
    void updateBooth(Booth booth);

    @Select("select * from booth where eid=#{eid}")
    List<Booth> findAllByEidForShow(Integer eid);
}
