package cn.ith.dao;

import cn.ith.domain.Exhibit;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author muyun
 * @date 2020/3/27 - 18:19
 */

@Repository
public interface IExhibitDao {

    //查询所有展会信息
    @Select("select * from exhibition")
    List<Exhibit> findAll() throws Exception;

    //查询指定id的信息
    @Select("select * from exhibition where id=#{id}")
    Exhibit findOneByid(Integer id) throws Exception;

    @Select(("select id from exhibition"))
    List<String> findAllId();

    //保存展会信息
    @Insert("insert into exhibition (eName,address,startDate,endDate) values(#{eName},#{address},#{startDate},#{endDate})")
    void saveExhibit(Exhibit exhibit);

    //删除通过id
    @Delete("delete from exhibition where id=#{id}")
    void delExById(Integer id);

    @Update("update exhibition set eName=#{eName},address=#{address},startDate=#{startDate},endDate=#{endDate} where id=#{id}")
    void updateExhibit(Exhibit exhibit);

    @Select("select * from exhibition where id=#{id}")
    @Results(value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "eName",property = "eName"),
            @Result(column = "address",property = "address"),
            @Result(column = "startDate",property = "startDate"),
            @Result(column = "endDate",property = "endDate"),
            @Result(column = "id" ,property = "companies",javaType = List.class,many = @Many(select = "cn.ith.dao.ICompanyDao.findByEidForShow")),
            @Result(column = "id",property = "booths",javaType=List.class,many = @Many(select = "cn.ith.dao.IBoothDao.findAllByEidForShow"))
    })
    Exhibit findOneByIdForShow(Integer id);
}
