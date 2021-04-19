package com.example.ProjectJavaWebApp.model.senpSeoDao;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class Hypothese {

    private HypotheseId id;
    private Long valeur1;
    private Long valeur2;
    private Long valeur3;
    private String etiquette;
  //  private IntervalleConfiance intervalleConfiance;
    private boolean visible;
    private boolean valide;
}
