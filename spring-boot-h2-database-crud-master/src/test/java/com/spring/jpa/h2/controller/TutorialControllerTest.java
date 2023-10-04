package com.spring.jpa.h2.controller;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.spring.jpa.h2.entity.Tutorial;
import com.spring.jpa.h2.repository.TutorialRepository;

public class TutorialControllerTest {
   @Mock
    TutorialRepository repo;

   @BeforeEach
    public void init(){
       MockitoAnnotations.initMocks(this);
    }

     @Test
    public void getAllTutorialsTest(){
       List<Tutorial> tutorials= new ArrayList<Tutorial>();
        Tutorial t1= new Tutorial("Chanikya", "Great leader", true);
         Tutorial t2= new Tutorial("Chanikya1", "Great leader2", true);
         Tutorial t3= new Tutorial("Chandra Gupta", "Great leader3", false);
         tutorials.add(t1);
         tutorials.add(t2);
         tutorials.add(t3);
     when (repo.findAll()).thenReturn(tutorials);
     }
}
