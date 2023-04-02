package com.company;

public class Dept {



    private long Deptno;

    private String Dname;

    private String loc;

    public long getDeptno() {
        return Deptno;
    }

    public String getDname() {
        return Dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setDeptno(long deptno) {
        Deptno = deptno;
    }

    public void setDname(String dname) {
        Dname = dname;
    }



    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "Deptno=" + Deptno +
                ", Dname='" + Dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
