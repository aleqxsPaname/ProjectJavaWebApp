package com.example.ProjectJavaWebApp.model.senpSeoGraph;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
public class GraphData {


    List<Courbe> courbes = new ArrayList<>();
    @Setter
    Long seoLimite;
    @Setter
    Long senpLimite;

    public void addCourbe(int id, String etiquette, List<Point> points){
        try{
            Courbe courbe = new Courbe(id, "Hypothese_" + id, createColorDependingOnId(id), etiquette, points);
            courbes.add(courbe);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String createColorDependingOnId(int id){
        if(id==1)return "green";
        if(id==2)return "blue";
        if(id==3)return "purple";
        if(id==4)return "red";
        if(id==5)return "darkBlue";
        if(id==6)return "orange";
        return "black";
    }


}
