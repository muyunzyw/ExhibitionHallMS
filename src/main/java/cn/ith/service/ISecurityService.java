package cn.ith.service;

import cn.ith.domain.Booth;
import cn.ith.domain.Security;

import java.util.List;

/**
 * @author muyun
 * @date 2020/3/27 - 18:22
 */
public interface ISecurityService {

    List<Security> findAll(int page) throws Exception;

    Security findOneById(Integer id) throws Exception;

    void saveSecurity(Security security);

    void delSeById(Integer id);

    void delSeByArr(Integer[] ids);

    void updateSecurity(Security security);

}
