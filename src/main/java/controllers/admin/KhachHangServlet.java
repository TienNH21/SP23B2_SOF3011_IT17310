package controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.KhachHangRepository;
import view_model.QLKhachHang;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
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
    private KhachHangRepository khRepo;

    public KhachHangServlet()
    {
        this.khRepo = new KhachHangRepository();
        this.khRepo.insert(new QLKhachHang("PH1", "Ng", "Van", "A", "HN", "0123123123", "1231231", "HN", "VN", "12-12-2022"));
        this.khRepo.insert(new QLKhachHang("PH2", "Tr", "Thi", "B", "HN", "0123123123", "1231231", "HN", "VN", "12-12-2022"));
    }

    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLKhachHang vm = this.khRepo.findByMa(ma);
        request.setAttribute("kh", vm);
        request.getRequestDispatcher("/views/khach_hang/edit.jsp")
                .forward(request, response);
    }

    protected void delete(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLKhachHang vm = this.khRepo.findByMa(ma);
        this.khRepo.delete(vm);

        response.sendRedirect("/SP23B2_SOF3011_IT17310_war_exploded/khach-hang/index");
    }

    protected void index(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachKH", this.khRepo.findAll());
//        request.getRequestDispatcher("/views/khach_hang/index.jsp")
        request.setAttribute("view", "/views/khach_hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
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
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/SP23B2_SOF3011_IT17310_war_exploded/khach-hang/index");
            // 404: Not Found
            // 405: Method Not Allowed
        }
    }

    protected void update(
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

        System.out.println("ma:" + ma);
        System.out.println("ten:" + ten);

        QLKhachHang vm = new QLKhachHang(ma, ho, tenDem, ten, ngaySinh, sdt, diaChi, quocGia, thanhPho, matKhau);
        this.khRepo.update(vm);
        response.sendRedirect("/SP23B2_SOF3011_IT17310_war_exploded/khach-hang/index");
    }

    protected void store(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            QLKhachHang vm = new QLKhachHang();
            BeanUtils.populate(vm, request.getParameterMap());
            this.khRepo.insert(vm);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/SP23B2_SOF3011_IT17310_war_exploded/khach-hang/index");
    }
}
