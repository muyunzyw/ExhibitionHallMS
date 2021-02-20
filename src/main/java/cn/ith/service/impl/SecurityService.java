package cn.ith.service.impl;

import cn.ith.dao.ISecurityDao;
import cn.ith.domain.Security;
import cn.ith.service.ISecurityService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author muyun
 * @date 2020/3/31 - 21:11
 */
@Service
public class SecurityService implements ISecurityService {

    @Autowired
    private ISecurityDao securityDao;

    @Override
    public List<Security> findAll(int page) throws Exception {
        //pageNum是页码值，pageSize是每页显示条数
        PageHelper.startPage(page,4);
        return securityDao.findAll();
    }

    @Override
    public Security findOneById(Integer id) throws Exception {
        return securityDao.findOneByid(id);
    }

    @Override
    public void saveSecurity(Security security) {
        securityDao.saveSecurity(security);
    }

    @Override
    public void delSeById(Integer id) {
        securityDao.delSeById(id);
    }

    @Override
    public void delSeByArr(Integer[] ids) {
        for(int i=0;i<ids.length;i++){
            securityDao.delSeById(ids[i]);
        }
    }

    @Override
    public void updateSecurity(Security security) {
        securityDao.updateSecurity(security);
    }
}
