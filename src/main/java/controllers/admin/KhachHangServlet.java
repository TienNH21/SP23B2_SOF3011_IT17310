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
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
//            this.edit(request, response);
        } else if (uri.contains("delete")) {
//            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void index(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachKH", list);
        request.getRequestDispatcher("/views/khach_hang/index.jsp")
            .forward(request, response);
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
        System.out.println(list.size());
    }
}
