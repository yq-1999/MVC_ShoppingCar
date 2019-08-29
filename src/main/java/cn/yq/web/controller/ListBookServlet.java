package cn.yq.web.controller;

import cn.yq.service.BusinessService;
import cn.yq.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author 钦
 * @create 2019-08-29 16:51
 */
public class ListBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BusinessService businessService=new BusinessServiceImpl();
        Map map=businessService.getAll();
        request.setAttribute("map",map);

        request.getRequestDispatcher("/WEB-INF/jsp/listbook.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        doPost(request, response);
    }
}
