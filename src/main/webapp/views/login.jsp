<%--
  Created by IntelliJ IDEA.
  User: tiennh
  Date: 4/3/23
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>

<c:if test="${ not empty errorMessage }">
    <div class="alert alert-danger">${ errorMessage }</div>
</c:if>

<form action="/SP23B2_SOF3011_IT17310_war_exploded/login" method="post">
    <div class="mt-3">
        <label>Mã</label>
        <input type="text" name="ma" class="form-control" />
    </div>
    <div class="mt-3">
        <label>Mật khẩu</label>
        <input type="password" name="matKhau" class="form-control" />
    </div>
    <div class="mt-3">
        <button class="btn btn-primary">Đăng nhập</button>
    </div>
</form>

