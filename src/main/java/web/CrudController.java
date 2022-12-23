package web;

import dao.Product;
import dao.ProductDaoImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/hi")
public class CrudController extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.getWriter().println(req.getRequestURI().split("/")[2]);
    }
}
