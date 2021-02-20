package cn.ith.service.impl;

import cn.ith.dao.ISpersonDao;
import cn.ith.domain.Sperson;
import cn.ith.service.ISpersonService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author muyun
 * @date 2020/3/31 - 20:09
 */
@Service
public class SpersonService implements ISpersonService {

    @Autowired
    private ISpersonDao spersonDao;

    @Override
    public List<Sperson> findAll(int page) throws Exception {
        //pageNum是页码值，pageSize是每页显示条数
        PageHelper.startPage(page,4);
        return spersonDao.findAll();
    }

    @Override
    public List<Sperson> findAllNoPage() throws Exception {
        return spersonDao.findAll();
    }

    @Override
    public Sperson findOneById(Integer id) throws Exception {
        return spersonDao.findOneByid(id);
    }

    @Override
    public void saveSperson(Sperson sperson) {
        spersonDao.saveSperson(sperson);
    }

    @Override
    public void delSpById(Integer id) {
        spersonDao.delSpById(id);
    }

    @Override
    public void delSpByArr(Integer[] ids) {
        for(int i=0;i<ids.length;i++){
            spersonDao.delSpById(ids[i]);
        }
    }

    @Override
    public void updateSperson(Sperson sperson) {
        spersonDao.updateSperson(sperson);
    }

}
