package cn.yq.dao;

import cn.yq.domain.Book;

import java.util.Map;

/**
 * @author 钦
 * @create 2019-08-29 16:33
 */
public interface BookDao {
    /**
     * 返回数据库所有数据
     * @return
     */
    public Map getAll();
    /**
     * 根据id进行查找
     */
    public Book FindById(String id);

}
