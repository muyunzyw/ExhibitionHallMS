package cn.ith.service;

import cn.ith.domain.Booth;
import cn.ith.domain.Sperson;

import java.util.List;

/**
 * @author muyun
 * @date 2020/3/27 - 18:22
 */
public interface ISpersonService {

    List<Sperson> findAll(int page) throws Exception;

    List<Sperson> findAllNoPage() throws Exception;

    Sperson findOneById(Integer id) throws Exception;

    void saveSperson(Sperson sperson);

    void delSpById(Integer id);

    void delSpByArr(Integer[] ids);

    void updateSperson(Sperson sperson);

}
