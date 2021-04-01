package com.example.ProjectJavaWebApp;

import com.example.ProjectJavaWebApp.model.Employee;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {

        private Gson gson = new Gson();

        @Override
        protected void doGet(
                HttpServletRequest request,
                HttpServletResponse response) throws IOException {

            Employee employee1 = new Employee(1, "Karan", "IT", 5000);
            Employee employee2 = new Employee(2, "Eddy", "IT", 5000);
            List<Employee> employees = new ArrayList<>();
            employees.add(employee1);
            employees.add(employee2);
            String employeeJsonString = this.gson.toJson(employees);

            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(employeeJsonString);
            out.flush();
        }
    }