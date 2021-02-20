package cn.ith.dao;

import cn.ith.domain.Booth;
import cn.ith.domain.Sperson;
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
public interface ISpersonDao {

    //查询所有信息
    @Select("select * from sperson")
    List<Sperson> findAll() throws Exception;

    //查询指定id的信息
    @Select("select * from sperson where id=#{id}")
    Sperson findOneByid(Integer id) throws Exception;

    //保存信息
    @Insert("insert into sperson (name,age,sex,idCard,phone) values(#{name},#{age},#{sex},#{idCard},#{phone})")
    void saveSperson(Sperson sperson);

    //删除通过id
    @Delete("delete from sperson where id=#{id}")
    void delSpById(Integer id);

    //更新信息
    @Update("update sperson set name=#{name},age=#{age},sex=#{sex},idCard=#{idCard},phone=#{phone} where id=#{id}")
    void updateSperson(Sperson sperson);
}
