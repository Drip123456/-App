package com.example.personwork.pojo;

public class Info {
    /*用户ID（学号）、用户名（姓名），手机号码，用户单位（班级），*/
    String xuehao;
    String name;
    String phone;
    String a_class;

    public Info(String xuehao, String name, String phone, String a_class) {
        this.xuehao = xuehao;
        this.name = name;
        this.phone = phone;
        this.a_class = a_class;
    }

    public Info() {
    }

    public String getXuehao() {
        return xuehao;
    }

    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getA_class() {
        return a_class;
    }

    public void setA_class(String a_class) {
        this.a_class = a_class;
    }
}
