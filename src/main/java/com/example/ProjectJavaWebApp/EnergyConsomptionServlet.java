package com.example.ProjectJavaWebApp;

import com.example.ProjectJavaWebApp.model.Employee;
import com.example.ProjectJavaWebApp.model.EnergyConsomptionData;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EnergyConsomptionServlet", urlPatterns = "/clos")
public class EnergyConsomptionServlet extends HttpServlet {

    private Gson gson = new Gson();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        EnergyConsomptionData data1 = new EnergyConsomptionData("07:00",3500);
        EnergyConsomptionData data2 = new EnergyConsomptionData("14:00", 3300);
        EnergyConsomptionData data3 = new EnergyConsomptionData("18:00", 3500);
        List<EnergyConsomptionData> datas = new ArrayList<>();
        datas.add(data1);
        datas.add(data2);
        datas.add(data3);
        String datasJsonString = this.gson.toJson(datas);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(datasJsonString);
        out.flush();
    }
}