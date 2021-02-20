package cn.ith.domain;

import java.io.Serializable;

/**
 * @author muyun
 * @date 2020/3/31 - 14:55
 */
public class Product implements Serializable {
    private Integer id;
    private Integer cid;
    private String pName;
    private Double height;
    private Double area;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", cid=" + cid +
                ", pName='" + pName + '\'' +
                ", height=" + height +
                ", area=" + area +
                ", type='" + type + '\'' +
                '}';
    }
}
