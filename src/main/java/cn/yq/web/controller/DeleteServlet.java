package cn.yq.web.controller;

import cn.yq.domain.Cart;
import cn.yq.exception.CartNotFoundException;
import cn.yq.service.BusinessService;
import cn.yq.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 钦
 * @create 2019-08-29 18:58
 */
//删除购买书的Servlet
public class DeleteServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String bookid = request.getParameter("bookid");

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        BusinessService service = new BusinessServiceImpl();
        try {
            service.deleteBook(bookid,cart);
            request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);

        } catch (CartNotFoundException e) {
            request.setAttribute("message", "对不起，您还没有购买任何商品!!!");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
