package com.android.recycleviewppp;

public class Student {
    String name, facno, phone;

    public Student() {}

    public Student(String name, String facno, String phone) {
        this.name = name;
        this.facno = facno;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
