package cn.ith.service.impl;

import cn.ith.dao.IExhibitDao;
import cn.ith.domain.Exhibit;
import cn.ith.service.IExhibitService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muyun
 * @date 2020/3/27 - 18:24
 */
@Service
public class ExhibitService implements IExhibitService {

    @Autowired
    private IExhibitDao exhibitDao;

    @Override
    public List<Exhibit> findAll(int page) throws Exception {
        //pageNum是页码值，pageSize是每页显示条数
        PageHelper.startPage(page,4);
        return exhibitDao.findAll();
    }

    @Override
    public List<Exhibit> findAllNoPage() throws Exception {
        return exhibitDao.findAll();
    }


    @Override
    public Exhibit findOneById(Integer id) throws Exception {
        return exhibitDao.findOneByid(id);
    }

    @Override
    public void saveExhibit(Exhibit exhibit) {
        exhibitDao.saveExhibit(exhibit);
    }

    @Override
    public void delExById(Integer id) {
        exhibitDao.delExById(id);
    }

    @Override
    public void delExByArr(Integer[] ids) {
        for(int i=0;i<ids.length;i++){
            exhibitDao.delExById(ids[i]);
        }
    }

    @Override
    public void updateExhibit(Exhibit exhibit) {
        exhibitDao.updateExhibit(exhibit);
    }

    @Override
    public Exhibit findOneByidForShow(Integer id) {
        return exhibitDao.findOneByIdForShow(id);
    }


}
