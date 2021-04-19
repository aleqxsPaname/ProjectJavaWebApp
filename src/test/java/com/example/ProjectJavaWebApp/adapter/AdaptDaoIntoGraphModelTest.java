package com.example.ProjectJavaWebApp.adapter;

import com.example.ProjectJavaWebApp.model.senpSeoDao.Hypothese;
import com.example.ProjectJavaWebApp.model.senpSeoDao.HypotheseId;
import com.example.ProjectJavaWebApp.model.senpSeoDao.IntervalleConfiance;
import com.example.ProjectJavaWebApp.model.senpSeoDao.ZoneTravail;
import com.example.ProjectJavaWebApp.model.senpSeoGraph.GraphData;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class AdaptDaoIntoGraphModelTest {

    public AdaptDaoIntoGraphModel adaptDaoIntoGraphModel = new AdaptDaoIntoGraphModel();

    @Test
    public void should_do_something_simple(){
        // GIVEN

        // WHEN
        String resultatToBeTested = adaptDaoIntoGraphModel.processTest();

        // THEN
        assertThat(resultatToBeTested).isEqualTo("ok");
    }

    @Test
    public void should_retrieve_complete_JSON(){
        // GIVEN
        IntervalleConfiance intevalleConfiancesSampleSENP = generateIntervalleConfianceSenpMatin();
        IntervalleConfiance intevalleConfiancesSampleSEO = generateIntervalleConfianceSeoMatin();

        // WHEN
        GraphData graphData = adaptDaoIntoGraphModel.process(intevalleConfiancesSampleSENP, intevalleConfiancesSampleSEO);

        // THEN
        assertThat(graphData.getSenpLimite()).isEqualTo(1300L);
        assertThat(graphData.getCourbes().get(2).getPoints().get(0).getValueSeo()).isEqualTo(230L);
        assertThat(graphData.getCourbes().get(2).getPoints().get(0).getValueSenp()).isEqualTo(1001L);
        assertThat(graphData.getCourbes().get(1).getEtiquette()).isEqualTo("hyp2");
        assertThat(graphData.getCourbes().size()).isEqualTo(4);
    }

    private IntervalleConfiance generateIntervalleConfianceSenpMatin(){
        Set<Hypothese> hypotheseSet = new HashSet<>();
        hypotheseSet.add(new Hypothese(new HypotheseId(1),1000L, 1200L, 1400L,"hyp1", true, true));
        hypotheseSet.add(new Hypothese(new HypotheseId(2),1000L, 1200L, 1400L,"hyp2", true, true));
        hypotheseSet.add(new Hypothese(new HypotheseId(3),1001L, 1200L, 1400L,"hyp3", true, true));
        hypotheseSet.add(new Hypothese(new HypotheseId(4),1000L, 1200L, 1400L,"hyp4", false, true));
        hypotheseSet.add(new Hypothese(new HypotheseId(5),null, null, 1400L,"hyp5", true, true));
        hypotheseSet.add(new Hypothese(new HypotheseId(6),1000L, 1200L, 1400L,"hyp6", true, true));

        ZoneTravail zoneTravail = new ZoneTravail();
        zoneTravail.setLibelle("SENP");
        IntervalleConfiance intervalleConfiance = new IntervalleConfiance(zoneTravail, 1300L, hypotheseSet, true);
        return intervalleConfiance;
    }

    private IntervalleConfiance generateIntervalleConfianceSeoMatin(){
        Set<Hypothese> hypotheseSet = new HashSet<>();
        hypotheseSet.add(new Hypothese(new HypotheseId(1),100L, 150L, 200L,"hyp1", true, true));
        hypotheseSet.add(new Hypothese(new HypotheseId(2),120L, 130L, 140L,"hyp2", true, true));
        hypotheseSet.add(new Hypothese(new HypotheseId(3),230L, 220L, 240L,"hyp3", true, true));
        hypotheseSet.add(new Hypothese(new HypotheseId(4),140L, 120L, 140L,"hyp4", false, true));
        hypotheseSet.add(new Hypothese(new HypotheseId(5),140L, 120L, 140L,"hyp5", true, true));
        hypotheseSet.add(new Hypothese(new HypotheseId(6),140L, 120L, 140L,"hyp6", true, true));

        ZoneTravail zoneTravail = new ZoneTravail();
        zoneTravail.setLibelle("SEO");
        IntervalleConfiance intervalleConfiance = new IntervalleConfiance(zoneTravail, 1300L, hypotheseSet, true);
        return intervalleConfiance;
    }

}