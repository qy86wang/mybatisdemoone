package com.aaa.mb.entity;

import java.util.List;

/**
 * className:Dept
 * discriptoin: 部门实体
 * author:WangPJ
 * createTime:2018-11-03 16:09
 */
public class Dept {
    private  int deptNo;
    private  String dname;
    private  String loc;

    private List<Emp> empList;

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
