package cn.ith.service.impl;

import cn.ith.dao.IBoothDao;
import cn.ith.domain.Booth;
import cn.ith.domain.Company;
import cn.ith.service.IBoothService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author muyun
 * @date 2020/3/31 - 16:49
 */
@Service
public class BoothService implements IBoothService {

    @Autowired
    private IBoothDao boothDao;

    @Override
    public List<Booth> findAll(int page) throws Exception {
        //pageNum是页码值，pageSize是每页显示条数
        PageHelper.startPage(page,4);
        return boothDao.findAll();
    }

    @Override
    public Booth findOneById(Integer id) throws Exception {
        return boothDao.findOneByid(id);
    }

    @Override
    public void saveBooth(Booth booth) {
        boothDao.saveBooth(booth);
    }

    @Override
    public void delBoById(Integer id) {
        boothDao.delBoById(id);
    }

    @Override
    public void delBoByArr(Integer[] ids) {
        for(int i=0;i<ids.length;i++){
            boothDao.delBoById(ids[i]);
        }
    }

    @Override
    public void updateBooth(Booth booth) {
        boothDao.updateBooth(booth);
    }

}
