package com.example.ProjectJavaWebApp.model.senpSeoGraph;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class Courbe {

    private String name;

    private String color;

    private String comment;

    private List<Point> points;

    public List<Point> getPoints(){
        System.out.println("YES WE ARE INSIDE THIS METHOD");
        return getPointsWhereSenpOverLimit();
    }

    private List<Point> getPointsWhereSenpOverLimit(){
        List<Point> pointToBeReturned = new ArrayList<>();
        List<Point> points = this.points;
        for(Point point:points) {
            if (point.getValueSenp() > 1500) {
                pointToBeReturned.add(point);
            } else {
                System.out.println("INVALID POINT IDENTIFIED");
            }
        }
        return pointToBeReturned;
    }
}
