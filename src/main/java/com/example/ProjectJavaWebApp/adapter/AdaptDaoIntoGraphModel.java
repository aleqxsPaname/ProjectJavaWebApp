package com.example.ProjectJavaWebApp.adapter;

import com.example.ProjectJavaWebApp.model.senpSeoDao.Hypothese;
import com.example.ProjectJavaWebApp.model.senpSeoDao.IntervalleConfiance;
import com.example.ProjectJavaWebApp.model.senpSeoGraph.GraphData;
import com.example.ProjectJavaWebApp.model.senpSeoGraph.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AdaptDaoIntoGraphModel {

    GraphData graphData = new GraphData();

    public String processTest(){
        return "ok";
    }

    public GraphData process(IntervalleConfiance intervalleConfiancesSENP, IntervalleConfiance intervalleConfiancesSEO){
        createCourbes(intervalleConfiancesSENP.getHypotheses(), intervalleConfiancesSEO.getHypotheses());
        assignLimiteIntoGraphData(intervalleConfiancesSENP.getValeur(), intervalleConfiancesSEO.getValeur());
        return this.graphData;
    }

    private void createCourbes(Set<Hypothese> hypothesesSENP, Set<Hypothese> hypothesesSEO) {
        for(int index = 1; index<=hypothesesSENP.size(); index++){
            try{
                Hypothese hypotheseSENP = retrieveHypotheseWithHypoId(index, hypothesesSENP);
                Hypothese hypotheseSEO = retrieveHypotheseWithHypoId(index, hypothesesSEO);
                createCourbeFromHypotheseSENPandHypotheseSEO(index, hypotheseSENP, hypotheseSEO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Hypothese retrieveHypotheseWithHypoId(int hypoId, Set<Hypothese> hypotheses) throws Exception {
        for(Hypothese hypothese:hypotheses){
            if(hypothese.getId().getHypoId() == hypoId){
                return hypothese;
            }
        }
        throw new Exception("hypthese should have hypothese id with value within this scope");
    }

    private void createCourbeFromHypotheseSENPandHypotheseSEO(int index, Hypothese hypotheseSENP, Hypothese hypotheseSEO){
        if(courbeShouldBeVisible(hypotheseSENP)){
            List<Point> points = new ArrayList<>();
            points.add(new Point(hypotheseSENP.getValeur1(), hypotheseSEO.getValeur1())) ;
            points.add(new Point(hypotheseSENP.getValeur2(), hypotheseSEO.getValeur2())) ;
            points.add(new Point(hypotheseSENP.getValeur3(), hypotheseSEO.getValeur3())) ;
            String etiquette = hypotheseSENP.getEtiquette();
            graphData.addCourbe(index, etiquette, points);
        }
    }

    private boolean courbeShouldBeVisible(Hypothese hypotheseSENP){
        if(hypotheseSENP.isVisible()) return true;
        return false;
    }

    private void assignLimiteIntoGraphData(Long valeurSENP, Long valeurSEO){
        this.graphData.setSenpLimite(valeurSENP);
        this.graphData.setSeoLimite(valeurSEO);
    }



















   /* private boolean isIntervalleConfianceASenp(IntervalleConfiance intervalleConfiance){
        if(intervalleConfiance.getZoneTravail().getLibelle().equals("SENP")){
            return true;
        }
        return false;
    }

    private boolean isThisHypotheseConvertibleIntoACourbe(){
        hasAtLeast2valuesToBuildAline();
        isVisible();

    }

    private boolean hasAtLeast2valuesToBuildAline(Hypothese hypothese){
        if(countNumberOfValueNotNull(hypothese)>=2){
            return true;
        }return false;
    }

    private int countNumberOfValueNotNull(Hypothese hypothese){
        int valeurNotNullCompteur = 0;
        if (!(hypothese.getValeur1() == null)) {
            valeurNotNullCompteur++;
        }
        if (!(hypothese.getValeur2() == null)) {
            valeurNotNullCompteur++;
        }
        if (!(hypothese.getValeur3() == null)) {
            valeurNotNullCompteur++;
        }
        return valeurNotNullCompteur;
    }*/
}
