package com.example.ProjectJavaWebApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Clos implements Serializable {

        @Id
        @GeneratedValue
        private static final long serialVersionUID = 1L;

        private Long id;
        private String heureDebut;
        private String heureFin;
        private Long closValue;
        private String commentaire;


}
