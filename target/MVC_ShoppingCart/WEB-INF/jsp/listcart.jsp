<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>购物车列表</title>
    <script type="text/javascript">
        function deleteItem(bookid){
            var b = window.confirm("您确定要删除吗？？");
            if(b){
                window.location.href="${pageContext.request.contextPath }/DeleteServlet?bookid="+bookid;
            }
        }

        function clearcart(){
            var b = window.confirm("您确定要清空购物车吗？？");
            if(b){
                window.location.href="${pageContext.request.contextPath}/ClearCartServlet";
            }
        }

        function updateCart(input,bookid,oldvalue){
            //得到修改的数量值
            var quantity = input.value;
            //alert(quantity);
            //检查输入值是不是为正整数
            if(quantity.match(/^[0-9]*[1-9][0-9]*$/)){
                var b = window.confirm("请确认改为：" + quantity);
                if(b){
                    window.location.href="${pageContext.request.contextPath}/UpdateCartServlet?bookid="+bookid + "&quantity=" + quantity;
                }else{
                    input.value=oldvalue;  //发现用户取消的话，把input输入值改为原始值
                }
            }else{
                alert("请输入正确购买数量");
                input.value=oldvalue;
            }

        }
    </script>
</head>
<body style="text-align: center;">
<br/>
<h2>购物车列表</h2>
<br/><br/>

    <c:if test="${empty(cart.map)}">
            你没有购买任何商品！！！
    </c:if>

    <c:if test="${!empty(cart.map)}">
    <table border="1" width="80%">
        <tr>
            <td>书名</td>
            <td>作者</td>
            <td>单价</td>
            <td>数量</td>
            <td>小计</td>
            <td>操作</td>
        </tr>

        <c:forEach var="me" items="${cart.map }">

            <tr>
                <td>${me.value.book.name }</td>
                <td>${me.value.book.author }</td>
                <td>${me.value.book.price }</td>
                <td>
                    <input type="text" name="quantity" value="${me.value.quantity }" style="width: 30px"
                           onchange="updateCart(this,${me.value.book.id },${me.value.quantity })">
                </td>
                <td>${me.value.price }</td>
                <td>
                    <%--href="javascipt:void(0)" 和return false;都是去掉超链接默认行为
                    有时候javascipt:void(0)在一些浏览器上不管用--%>
                    <a href="" onclick="deleteItem(${me.value.book.id });return false; ">删除</a>
                </td>
            </tr>

        </c:forEach>

        <tr>
            <td colspan="2">
                <a href="javascript:clearcart()">清空购物车</a>
            </td>
            <td colspan="2">合计</td>
            <td colspan="2">${cart.price }</td>
        </tr>

    </table>
    </c:if>
</body>
</html>
