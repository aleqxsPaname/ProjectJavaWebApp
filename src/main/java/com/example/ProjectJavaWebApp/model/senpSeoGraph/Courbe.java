package com.example.ProjectJavaWebApp.model.senpSeoGraph;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;



@NoArgsConstructor
@Getter
public class Courbe {

    private int index;
    private String name;
    private String color;
    private String etiquette;
    private List<Point> points;

    public Courbe(int index, String name, String color, String etiquette, List<Point> points) throws Exception{
        if(isListOfPointsValid(points)){
            this.index = index;
            this.name = name;
            this.color = color;
            this.etiquette = etiquette;
            this.points = points;
        }else{
            throw new Exception("invalid Points - you must at least have 2 valid points to create a courbe (impact=small) courbe won't be created");
        }
    }

    private boolean isListOfPointsValid(List<Point> points){
       return haveMoreThan2PointsWithValue(points);
    }

    private boolean haveMoreThan2PointsWithValue(List<Point> points){
        int validPointCompteur = 0;
        for(Point point:points) {
            if (point.getValueSenp() != null && point.getValueSeo() != null) {
                validPointCompteur++;
            }
        }
        if(validPointCompteur >= 2){
            return true;
        }
        return false;
    }

}
