package cn.yq.service;

import cn.yq.domain.Book;
import cn.yq.domain.Cart;
import cn.yq.exception.CartNotFoundException;

import java.util.Map;

/**
 * @author 钦
 * @create 2019-08-29 16:42
 */
public interface BusinessService {

    public Map getAll();

    public Book FindById(String id);

    public void deleteBook(String bookid, Cart cart) throws CartNotFoundException;

    public void clearCart(Cart cart) throws CartNotFoundException;

    public void updateCart(Cart cart, String bookid, int quantity) throws CartNotFoundException;
}
