/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kl438
 */
public   class Controller {
    private EntityManagerFactory emf = null;
    protected EntityManager em =  null;
    
    public Controller() {
        if (emf == null)
            emf = Persistence.createEntityManagerFactory("HMSPU");
        if (em == null)
            em = emf.createEntityManager();
    }
}
