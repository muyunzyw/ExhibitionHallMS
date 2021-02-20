package cn.ith.service;

import cn.ith.domain.Company;
import cn.ith.domain.Exhibit;

import java.util.List;

/**
 * @author muyun
 * @date 2020/3/27 - 18:22
 */
public interface ICompanyService {

    List<Company> findAll(int page) throws Exception;

    List<Company> findAllNoPage() throws Exception;

    Company findOneById(Integer id) throws Exception;
    Company findOneByIdForShow(Integer id) throws Exception;

    void saveCompany(Company company);

    void delComById(Integer id);

    void delComByArr(Integer[] ids);

    void updateCompany(Company company);
}
