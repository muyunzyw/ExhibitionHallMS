package cn.ith.controller;

import cn.ith.domain.Company;
import cn.ith.domain.Exhibit;
import cn.ith.domain.Product;
import cn.ith.service.ICompanyService;
import cn.ith.service.IProductService;
import cn.ith.service.impl.CompanyService;
import cn.ith.service.impl.ProductService;
import cn.ith.utils.IntUntils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;

/**
 * @author muyun
 * @date 2020/3/31 - 15:10
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICompanyService companyService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> proAll = productService.findAll(page);
        //PageInfo是一个分页bean
        PageInfo pageInfo = new PageInfo(proAll);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String saveProduct(Product product){
        productService.saveProduct(product);
        return "redirect:findAll.do";
    }

    //删除指定id集合的数据集
    @RequestMapping("/del.do")
    @RolesAllowed("ADMIN")
    public String delProduct( String[] ids){
        int[] array = Arrays.asList(ids).stream().mapToInt(Integer::parseInt).toArray();
        productService.delPrByArr(IntUntils.intToInteger(array));
        return "redirect:findAll.do";
    }

    //改变数据库中的信息
    @RequestMapping("/update.do")
    @RolesAllowed("ADMIN")
    public String updateProduct(Product product){
        productService.updateProduct(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/seach.do")
    public ModelAndView findOneById(String seach_id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Integer id = Integer.parseInt(seach_id);
        Product pro = productService.findOneById(id);
        mv.addObject("result",pro);
        mv.setViewName("product-seach");
        return mv;
    }

    @RequestMapping("/allId.do")
    public @ResponseBody
    List<Company> findAllCId() throws Exception {
        List<Company> companys  = companyService.findAllNoPage();
        return companys;

    }
}
