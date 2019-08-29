package cn.yq.db;

import cn.yq.domain.Book;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author 钦
 * @create 2019-08-29 16:20
 */
//模似数据库
public class DB {
    private static Map<String,Book> map=new LinkedHashMap<>();

    static{
        map.put("1", new Book("1","javaweb开发","俞钦",66,"一本经典的书"));
        map.put("2", new Book("2","jdbc开发","俞鹏",30,"一本jdbc的书"));
        map.put("3", new Book("3","spring开发","俞光头",50,"一本相当经典的书"));
        map.put("4", new Book("4","mabatis开发","俞",56,"一本框架的书"));
        map.put("5", new Book("5","struts2开发","陈某",40,"一本老框架的书"));
        map.put("6", new Book("6","jQuery开发","俞某",50,"一本前端技术的书"));
    }
    public static Map getAll(){
        return map;
    }

}
