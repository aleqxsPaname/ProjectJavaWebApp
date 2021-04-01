package com.example.ProjectJavaWebApp;

import com.example.ProjectJavaWebApp.model.EnergyConsomptionData;
import com.google.gson.Gson;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmployeeConsomptionBean implements Serializable {

    private Gson gson = new Gson();

    private static final long serialVersionUID = 1L;

    private String data;

    public String getData() {
        return generateData();
    }

    public void setData(String data) {
        this.data = data;
    }

    private String generateData() {
        EnergyConsomptionData data1 = new EnergyConsomptionData("07:00", 3500);
        EnergyConsomptionData data2 = new EnergyConsomptionData("14:00", 3300);
        EnergyConsomptionData data3 = new EnergyConsomptionData("18:00", 3500);
        List<EnergyConsomptionData> datas = new ArrayList<>();
        datas.add(data1);
        datas.add(data2);
        datas.add(data3);
        String datasJsonString = this.gson.toJson(datas);

        return datasJsonString;

       /* PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(datasJsonString);
        out.flush();*/
    }

}



