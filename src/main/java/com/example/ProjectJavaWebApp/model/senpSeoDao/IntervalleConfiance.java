package com.example.ProjectJavaWebApp.model.senpSeoDao;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
public class IntervalleConfiance {
    private ZoneTravail zoneTravail;
    private Long valeur;
    private Set<Hypothese> hypotheses = new HashSet<Hypothese>();
    private Boolean matin;
}
