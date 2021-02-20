package cn.ith.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author muyun
 * @date 2020/3/30 - 16:55
 */
public class Company implements Serializable {

    private Integer id;
    private Integer eid;
    private String cName;
    private String cPerson;
    private String phone;

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcPerson() {
        return cPerson;
    }

    public void setcPerson(String cPerson) {
        this.cPerson = cPerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", eid=" + eid +
                ", cName='" + cName + '\'' +
                ", cPerson='" + cPerson + '\'' +
                ", phone='" + phone + '\'' +
                ", products=" + products +
                '}';
    }
}
