package cn.studyjams.s2.sj0147.huangkai.bean;

import java.text.SimpleDateFormat;
import java.util.Date;



public class SendeMsg {
    private int id;
    private String msg;
    private String numbers;
    private String names ;
    private String festivalName;
    private String date;
    private String dateStr;

    public  static final String TABLE_NAME= "tb_snded_msg";
    public  static final String COLUMU_MSG= "msg";
    public  static final String COLUMU_NUMBERS= "numbers";
    public  static final String COLUMU_NAMES= "names";
    public  static final String COLUMU_FESTIVALNAME= "festivalName";
    public  static final String COLUMU_DATE= "date";
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getFestivalName() {
        return festivalName;
    }

    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public String getDateStr() {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        dateStr = df.format(getDate());
//        return dateStr;
//    }



}
