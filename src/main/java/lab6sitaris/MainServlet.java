package lab6sitaris;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lab6sitaris.parser.Catalog;
import lab6sitaris.parser.Parser;
import lab6sitaris.parser.productfactory.FaceCream;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("")
public class MainServlet  extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {




        Catalog catalog = Parser.parseCatalog();


        req.setAttribute("avg", catalog.average());
        req.setAttribute("products", catalog.getProducts());
        req.setAttribute("names", catalog.getNames());
        req.setAttribute("prices", catalog.getPrices());
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp); //переадресация на страницу

    }

}