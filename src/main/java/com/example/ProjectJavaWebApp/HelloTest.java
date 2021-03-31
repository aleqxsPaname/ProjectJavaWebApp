package com.example.ProjectJavaWebApp;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class HelloTest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return "Alexis from HelloTest";
    }
    public void setName(String name) {
        this.name = name;
    }
}