<%--
  Created by IntelliJ IDEA.
  User: tiennh
  Date: 3/10/23
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/SP23B2_SOF3011_IT17310_war_exploded/css/bootstrap.min.css" />
</head>
<body>
    <div class="col-8 offset-2">
        <form method="POST"
          action="/SP23B2_SOF3011_IT17310_war_exploded/khach-hang/update?ma=${ kh.ma }">
            <div class="row mt-3">
                <div class="col-6">
                    <label>Mã</label>
                    <input type="text" name="Ma" class="form-control" value="${ kh.ma }" disabled />
                </div>
                <div class="col-6">
                    <label>Họ</label>
                    <input type="text" name="ho" class="form-control" value="${ kh.ho }" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Tên đệm</label>
                    <input type="text" name="tenDem" class="form-control" value="${ kh.tenDem }" />
                </div>
                <div class="col-6">
                    <label>Tên</label>
                    <input type="text" name="ten" class="form-control" value="${ kh.ten }" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Ngày sinh</label>
                    <input type="date" name="ngaySinh" class="form-control" value="${ kh.ngaySinh }" />
                </div>
                <div class="col-6">
                    <label>SDT</label>
                    <input type="tel" name="sdt" class="form-control" value="${ kh.sdt }" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Địa chỉ</label>
                    <input type="text" name="diaChi" class="form-control" value="${ kh.diaChi }" />
                </div>
                <div class="col-6">
                    <label>Mật khẩu</label>
                    <input type="password" name="matKhau" class="form-control" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Quốc gia</label>
                    <select name="quocGia" class="form-select">
                        <option ${ kh.quocGia == "vi" ? "selected" : "" } value="vi">Việt Nam</option>
                        <option ${ kh.quocGia == "us" ? "selected" : "" } value="us">Mỹ</option>
                    </select>
                </div>
                <div class="col-6">
                    <label>Thành phố</label>
                    <select name="thanhPho" class="form-select">
                        <option value="ha_noi">Hà Nội</option>
                        <option value="new_york">New York</option>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <button class="btn btn-primary">Thêm mới</button>
                </div>
                <div class="col-6"></div>
            </div>
        </form>
    </div>
    <script src="/SP23B2_SOF3011_IT17310_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
