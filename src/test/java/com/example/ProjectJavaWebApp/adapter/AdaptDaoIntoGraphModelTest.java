package com.example.ProjectJavaWebApp.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdaptDaoIntoGraphModelTest {

    public AdaptDaoIntoGraphModel adaptDaoIntoGraphModel = new AdaptDaoIntoGraphModel();

    @Test
    public void should_do_something_simple(){
        // GIVEN



        // WHEN
        String resultatToBeTested = adaptDaoIntoGraphModel.processTest();


        // THEN
        assertEquals("ok", resultatToBeTested);

    }




}