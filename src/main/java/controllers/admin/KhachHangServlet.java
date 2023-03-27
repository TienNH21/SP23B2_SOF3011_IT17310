package controllers.admin;

import domain_models.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.KhachHangRepository;
import view_model.QLKhachHang;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

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
        KhachHang domainModelKH = this.khRepo.findByMa(ma);
        request.setAttribute("kh", domainModelKH);
        request.getRequestDispatcher("/views/khach_hang/edit.jsp")
                .forward(request, response);
    }

    protected void delete(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang domainModelKH = this.khRepo.findByMa(ma);
        this.khRepo.delete(domainModelKH);

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
        try {
            String ma = request.getParameter("ma");
            /*
             * domainModelKH: Dữ liệu đang có trong DB
             * request.getParameterMap(): Dữ liệu người dùng cập nhật
             */
            KhachHang domainModelKH = this.khRepo.findByMa(ma);
            BeanUtils.populate(domainModelKH, request.getParameterMap());
            this.khRepo.update(domainModelKH);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/SP23B2_SOF3011_IT17310_war_exploded/khach-hang/index");
    }

    protected void store(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            KhachHang domainModelKH = new KhachHang();
            BeanUtils.populate(domainModelKH, request.getParameterMap());
            System.out.println(domainModelKH.getMa());
            this.khRepo.insert(domainModelKH);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/SP23B2_SOF3011_IT17310_war_exploded/khach-hang/index");
    }
}
