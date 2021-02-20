package cn.ith.domain;

import java.io.Serializable;

/**
 * @author muyun
 * @date 2020/3/31 - 21:03
 */
public class Security implements Serializable {
    private Integer id;
    private Integer sid;
    private Integer eid;
    private String extent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getExtent() {
        return extent;
    }

    public void setExtent(String extent) {
        this.extent = extent;
    }
}
