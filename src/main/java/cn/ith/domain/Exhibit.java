package cn.ith.domain;

import cn.ith.utils.DateUntils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author muyun
 * @date 2020/3/27 - 16:04
 */
public class Exhibit implements Serializable {

    private Integer id;

    private String eName;

    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startDate;

    private String startDateToStr;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endDate;

    private String endDateToStr;

    private List<Company> companies;

    private List<Booth> booths;

    public List<Booth> getBooths() {
        return booths;
    }

    public void setBooths(List<Booth> booths) {
        this.booths = booths;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) { this.address = address; }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStartDateToStr() {
        if(startDate!=null){
            return DateUntils.date2String(startDate, "yyyy-MM-dd HH:mm");
        }
        return "空";
    }

    public void setStartDateToStr(String startDateToStr) {
        this.startDateToStr = startDateToStr;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEndDateToStr() {
        if(endDate!=null){
            return DateUntils.date2String(endDate, "yyyy-MM-dd HH:mm");
        }
        return "空";
    }

    public void setEndDateToStr(String endDateToStr) {
        this.endDateToStr = endDateToStr;
    }

    @Override
    public String toString() {
        return "Exhibit{" +
                "id=" + id +
                ", eName='" + eName + '\'' +
                ", address='" + address + '\'' +
                ", startDate=" + startDate +
                ", startDateToStr='" + startDateToStr + '\'' +
                ", endDate=" + endDate +
                ", endDateToStr='" + endDateToStr + '\'' +
                ", companies=" + companies +
                ", booths=" + booths +
                '}';
    }
}
