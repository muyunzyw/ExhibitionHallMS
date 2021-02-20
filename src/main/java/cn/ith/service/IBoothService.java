package cn.ith.service;

import cn.ith.domain.Booth;
import cn.ith.domain.Product;

import java.util.List;

/**
 * @author muyun
 * @date 2020/3/27 - 18:22
 */
public interface IBoothService {

    List<Booth> findAll(int page) throws Exception;

    Booth findOneById(Integer id) throws Exception;

    void saveBooth(Booth booth);

    void delBoById(Integer id);

    void delBoByArr(Integer[] ids);

    void updateBooth(Booth booth);

}
