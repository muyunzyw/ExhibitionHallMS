package cn.ith.service;

import cn.ith.domain.Exhibit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muyun
 * @date 2020/3/27 - 18:22
 */
public interface IExhibitService {

    List<Exhibit> findAll(int page) throws Exception;

    List<Exhibit> findAllNoPage() throws Exception;

    Exhibit findOneById(Integer id) throws Exception;

    void saveExhibit(Exhibit exhibit);

    void delExById(Integer id);

    void delExByArr(Integer[] ids);

    void updateExhibit(Exhibit exhibit);

    Exhibit findOneByidForShow(Integer id);

}
