package com.minitest.controller;

import com.minitest.dao.ChildDao;
import com.minitest.model.child;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "servlet", value = "/childs")

public class servlet extends HttpServlet {
    private ChildDao childDao;

    public void init() {
        childDao = new ChildDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showNewList(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            default:
                showAllChildren(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "add":
                    addChild(req, resp);
                    break;
                case "edit":
                    editChild(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showAllChildren(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        List<child> children = childDao.displayAllChildren();
        req.setAttribute("newlist", children);
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        dispatcher.forward(req, resp);
    }

    private void showNewList(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
        dispatcher.forward(request, response);
    }

    private void addChild(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, ServletException, IOException {
        String fullname = request.getParameter("fullname");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        int idF = Integer.parseInt(request.getParameter("idF"));
        child newChild = new child(fullname, age, gender,idF);
        childDao.addNewChild(newChild);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
        dispatcher.forward(request, response);

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =  Integer.parseInt(request.getParameter("idS"));
        child child = childDao.getChildByIdS(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        request.setAttribute("child",child);
        dispatcher.forward(request, response);
    }

    private void editChild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idS"));
        String fullname = request.getParameter("fullname");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        int idF = Integer.parseInt(request.getParameter("idF"));
        child newChild = new child(id, fullname, age, gender,idF);
        childDao.editChild(newChild);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);

    }
}
