package cn.ith.dao;

import cn.ith.domain.Exhibit;
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
public interface IProductDao {

    //查询所有信息
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    //查询指定id的信息
    @Select("select * from product where id=#{id}")
    Product findOneByid(Integer id) throws Exception;

    //保存信息
    @Insert("insert into product (cid,pName,height,area,type) values(#{cid},#{pName},#{height},#{area},#{type})")
    void saveProduct(Product product);

    //删除通过id
    @Delete("delete from product where id=#{id}")
    void delPrById(Integer id);

    //更新信息
    @Update("update product set cid=#{cid},pName=#{pName},height=#{height},area=#{area},type=#{type} where id=#{id}")
    void updateProduct(Product product);

    @Select("select * from product where cid=#{cid}")
    List<Product> findAllByCid(Integer cid);
}
