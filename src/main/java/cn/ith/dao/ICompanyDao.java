package cn.ith.dao;

import cn.ith.domain.Company;
import cn.ith.domain.Exhibit;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author muyun
 * @date 2020/3/27 - 18:19
 */

@Repository
public interface ICompanyDao {

    //查询所有展会信息
    @Select("select * from company")
    List<Company> findAll() throws Exception;

    //查询指定id的信息
    @Select("select * from company where id=#{id}")
    Company findOneByid(Integer id) throws Exception;

    //保存展会信息
    @Insert("insert into company (eid,cName,cPerson,phone) values(#{eid},#{cName},#{cPerson},#{phone})")
    void saveCompany(Company company);

    //删除通过id
    @Delete("delete from company where id=#{id}")
    void delComById(Integer id);

    @Update("update company set eid=#{eid},cName=#{cName},cPerson=#{cPerson},phone=#{phone} where id=#{id}")
    void updateCompany(Company company);

    @Select("select * from company where eid=#{eid}")
    @Results(id = "result",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "eid",property = "eid"),
            @Result(column = "cName",property = "cName"),
            @Result(column = "cPerson",property = "cPerson"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "id",property = "products",javaType=List.class,many = @Many(select = "cn.ith.dao.IProductDao.findAllByCid"))
    }
    )
    List<Company> findByEidForShow(Integer eid);

    @Select("select * from company where id=#{id}")
    @ResultMap("result")
    Company findOneByIdForShow(Integer id) throws Exception;


}
