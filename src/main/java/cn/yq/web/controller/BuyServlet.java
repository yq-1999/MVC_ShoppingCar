package cn.yq.web.controller;


import cn.yq.domain.Book;
import cn.yq.domain.Cart;
import cn.yq.service.BusinessService;
import cn.yq.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 钦
 * @create 2019-08-29 17:44
 */

public class BuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("bookid");
        BusinessService businessService=new BusinessServiceImpl();
        Book book = businessService.FindById(id);

        //把用户买的书加到购物车中
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(cart==null){
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        //把书加入到购物车中，完成购买
        cart.add(book);

        request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        doPost(request, response);
    }
}
