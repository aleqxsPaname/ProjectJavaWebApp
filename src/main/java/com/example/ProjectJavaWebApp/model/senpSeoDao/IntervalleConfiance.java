package com.example.ProjectJavaWebApp.model.senpSeoDao;


import java.util.HashSet;
import java.util.Set;

public class IntervalleConfiance {
    private ZoneTravail zoneTravail;
    private Long valeur;
    private Set<Hypothese> hypotheses = new HashSet<Hypothese>();
    private Boolean matin;
}
