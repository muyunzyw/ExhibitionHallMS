package cn.ith.service.impl;

import cn.ith.dao.IProductDao;
import cn.ith.domain.Product;
import cn.ith.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author muyun
 * @date 2020/3/31 - 15:05
 */
@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll(int page) throws Exception {
        //pageNum是页码值，pageSize是每页显示条数
        PageHelper.startPage(page,4);
        return productDao.findAll();
    }

    @Override
    public Product findOneById(Integer id) throws Exception {
        return productDao.findOneByid(id);
    }

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    @Override
    public void delPrById(Integer id) {
        productDao.delPrById(id);
    }

    @Override
    public void delPrByArr(Integer[] ids) {
        for(int i=0;i<ids.length;i++){
            productDao.delPrById(ids[i]);
        }
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }
}
