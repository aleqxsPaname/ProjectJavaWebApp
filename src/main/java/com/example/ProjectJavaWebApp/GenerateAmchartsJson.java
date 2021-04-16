package com.example.ProjectJavaWebApp;

import com.example.ProjectJavaWebApp.model.Clim;
import com.example.ProjectJavaWebApp.model.Clos;
import com.example.ProjectJavaWebApp.model.senpSeoGraph.Courbe;
import com.example.ProjectJavaWebApp.model.senpSeoGraph.Point;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GenerateAmchartsJson {

    private Gson gson = new Gson();

    private static final long serialVersionUID = 1L;


    public String getDataclos(){
        List<Clos> closList = generateClosList();
        return this.gson.toJson(closList);
    }

    public String getDataclim(){
        List<Clim> climList = generateClimList();
        return this.gson.toJson(climList);
    }

    public String getHypotheses(){
        List<Courbe> courbes = generateHypothese();
        return this.gson.toJson(courbes);
    }

    private List<Clos> generateClosList(){
        List<Clos> closList = new ArrayList<>();
        Clos clos1 = new Clos(1L, "07:00", "10:00", 3000L, "sans");
        Clos clos2 = new Clos(2L, "10:00", "13:00", 2000L, "sans");
        Clos clos3 = new Clos(3L, "13:00", "17:00", 3200L, "sans");
        Clos clos4 = new Clos(4L, "17:00", "21:00", 2700L, "sans");
        closList.add(clos1);
        closList.add(clos2);
        closList.add(clos3);
        closList.add(clos4);
        return closList;
    }

    private List<Clim> generateClimList(){
        List<Clim> climList = new ArrayList<>();
        Clim clim1 = new Clim(1L, "07:00", "10:00", 2300L, "clim not serializabled");
        Clim clim2 = new Clim(2L, "10:00", "13:00", 2800L, "clim not serializabled");
        Clim clim3 = new Clim(3L, "13:00", "17:00", 3000L, "clim not serializabled");
        Clim clim4 = new Clim(4L, "17:00", "21:00", 2700L, "clim not serializabled");
        climList.add(clim1);
        climList.add(clim2);
        climList.add(clim3);
        climList.add(clim4);
        return climList;
    }

    private List<Courbe> generateHypothese(){
        List<Courbe> courbes = new ArrayList<>();
        courbes.add(new Courbe("hypothese1", "blue", "h1", generateRandomPoints()));
        courbes.add(new Courbe("hypothese2", "red", "h2", generateRandomPoints()));
        courbes.add(new Courbe("hypothese3", "purple", "h3", generateRandomPoints()));
        return courbes;
    }

    private List<Point> generateRandomPoints(){
        List<Point> points = new ArrayList();
        points.add(new Point(1000 + random(), 1100 + random()));
        points.add(new Point(1200 + random(), 1140 + random()));
        return points;
    }

    private int random(){
        Random random = new Random();
        int min = 1;
        int max = 1000;
        return random.nextInt(max - min + 1) + min;
    }

}
