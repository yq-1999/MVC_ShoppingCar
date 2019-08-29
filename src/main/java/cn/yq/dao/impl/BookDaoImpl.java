package cn.yq.dao.impl;

import cn.yq.dao.BookDao;
import cn.yq.db.DB;
import cn.yq.domain.Book;

import java.util.Map;

/**
 * @author 钦
 * @create 2019-08-29 16:37
 */
public class BookDaoImpl implements BookDao {
    DB db=new DB();

    @Override
    public Map getAll() {
        return db.getAll();
    }

    @Override
    public Book FindById(String id) {
        return (Book) db.getAll().get(id);
    }
}
