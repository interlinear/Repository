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

public class UploadServlet extends HttpServlet {

    public UploadServlet() {
    }

    private CouchDbClient dbClient;
    private DatabaseController dbController;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        System.out.println("\n\nUpload servlet\n\n");

        dbClient = DatabaseSetup.getDbCliend();

        dbController = new DatabaseController();
        Response resp = dbController.addToDatabase(dbClient);

        String docId = resp.getId();
        request.setAttribute("docId", docId);

        out.println("Finish with adding");

        RequestDispatcher dispatcher = request.getRequestDispatcher("afterAddedDocument.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("doPost");
    }
}
