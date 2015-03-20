package Servlet;

import Controller.DatabaseController;
import Controller.DatabaseSetup;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class UploadServlet extends HttpServlet {

    public UploadServlet() {
    }

    private CouchDbClient dbClient;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("doGet UploadServlet");

        dbClient = DatabaseSetup.getDbCliend();

        DatabaseController dbController = new DatabaseController();
        out.println(dbController.addToDatabase(dbClient));

        out.println("Finish with adding");

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("doPost");
    }
}
