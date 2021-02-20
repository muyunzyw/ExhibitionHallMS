package cn.ith.service;

import cn.ith.domain.Exhibit;
import cn.ith.domain.Product;

import java.util.List;

/**
 * @author muyun
 * @date 2020/3/27 - 18:22
 */
public interface IProductService {

    List<Product> findAll(int page) throws Exception;

    Product findOneById(Integer id) throws Exception;

    void saveProduct(Product product);

    void delPrById(Integer id);

    void delPrByArr(Integer[] ids);

    void updateProduct(Product product);

}
