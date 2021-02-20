package cn.ith.service.impl;

import cn.ith.dao.ICompanyDao;
import cn.ith.domain.Company;
import cn.ith.domain.Exhibit;
import cn.ith.service.ICompanyService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author muyun
 * @date 2020/3/27 - 18:24
 */
@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private ICompanyDao companyDao;

    @Override
    public List<Company> findAll(int page) throws Exception {
        //pageNum是页码值，pageSize是每页显示条数
        PageHelper.startPage(page,4);
        return companyDao.findAll();
    }

    @Override
    public List<Company> findAllNoPage() throws Exception {
        return companyDao.findAll();
    }

    @Override
    public Company findOneById(Integer id) throws Exception {
        return companyDao.findOneByid(id);
    }

    @Override
    public Company findOneByIdForShow(Integer id) throws Exception {
        return companyDao.findOneByIdForShow(id);
    }

    @Override
    public void saveCompany(Company company) {
        companyDao.saveCompany(company);
    }

    @Override
    public void delComById(Integer id) {
        companyDao.delComById(id);
    }

    @Override
    public void delComByArr(Integer[] ids) {
        for(int i=0;i<ids.length;i++){
            companyDao.delComById(ids[i]);
        }
    }

    @Override
    public void updateCompany(Company company) {
        companyDao.updateCompany(company);
    }


}
