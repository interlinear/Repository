package Servlet;

import Controller.DatabaseController;
import Controller.DatabaseSetup;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteServlet extends HttpServlet {

    public DeleteServlet() {
    }

    private CouchDbClient dbClient;
    private DatabaseController dbController;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("doGet DeleteServlet");
        String id = request.getParameter("id");

        dbClient = DatabaseSetup.getDbCliend();

        dbController = new DatabaseController();

        try {
            Response resp = dbController.removeDocument(dbClient, id);

            String deletedId = resp.getId();

            request.setAttribute("deletedId", deletedId);

        } catch (Exception e) {

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("afterDeletedDocument.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("doPost");
    }
}
