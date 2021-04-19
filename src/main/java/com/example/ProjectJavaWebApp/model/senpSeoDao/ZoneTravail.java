package com.example.ProjectJavaWebApp.model.senpSeoDao;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class ZoneTravail {

        @Getter
        @Setter
        private String libelle;
        private boolean principal;
        private String urse;
        private String codeSNC;
        private boolean processEtude;
}
