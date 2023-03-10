package controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import view_model.QLKhachHang;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet({
    "/khach-hang/index",    // GET
    "/khach-hang/create",   // GET
    "/khach-hang/store",    // POST
    "/khach-hang/edit",     // GET
    "/khach-hang/update",   // POST
    "/khach-hang/delete",   // GET
})
public class KhachHangServlet extends HttpServlet {
    private ArrayList<QLKhachHang> list = new ArrayList<>();
    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        this.create(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/khach_hang/create.jsp")
            .forward(request, response);
    }

    @Override
    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        this.store(request, response);
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ho = request.getParameter("ho");
        String tenDem = request.getParameter("ten_dem");
        String ten = request.getParameter("ten");
        String ngaySinh = request.getParameter("ngay_sinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("dia_chi");
        String quocGia = request.getParameter("quoc_gia");
        String thanhPho = request.getParameter("thanh_pho");
        String matKhau = request.getParameter("mat_khau");

        QLKhachHang vm = new QLKhachHang(ma, ho, tenDem, ten, ngaySinh, sdt, diaChi, quocGia, thanhPho, matKhau);
        list.add(vm);
    }
}
