package cn.yq.service.impl;

import cn.yq.dao.BookDao;
import cn.yq.dao.impl.BookDaoImpl;
import cn.yq.domain.Book;
import cn.yq.domain.Cart;
import cn.yq.domain.CartItem;
import cn.yq.exception.CartNotFoundException;
import cn.yq.service.BusinessService;

import java.util.Map;

/**
 * @author 钦
 * @create 2019-08-29 16:43
 */
public class BusinessServiceImpl implements BusinessService {

    BookDao bookDao=new BookDaoImpl();

    @Override
    public Map getAll() {
        return bookDao.getAll();
    }

    @Override
    public Book FindById(String id) {
        return bookDao.FindById(id);
    }

    @Override
    public void deleteBook (String bookid, Cart cart)throws CartNotFoundException {
            if(cart==null){
                throw new CartNotFoundException("购物车为空！！");
            }
        Map map = cart.getMap();
        map.remove(bookid);
    }

    @Override
    public void clearCart(Cart cart) throws CartNotFoundException {
        if(cart==null){
            throw new CartNotFoundException("购物车为空！！");
        }
        //清空map集合（清空购物车）
        cart.getMap().clear();
    }

    @Override
    public void updateCart(Cart cart, String bookid, int quantity) throws CartNotFoundException {

        if(cart==null){
            throw new CartNotFoundException("购物车为空！！");
        }
        CartItem item = cart.getMap().get(bookid);
        item.setQuantity(quantity);

    }
}
