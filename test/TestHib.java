/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import beans.LivreBean;
import entite.Livre;
import entite.Utilisateur;
import java.util.Iterator;
import java.util.List;
import business.ILivreMetier;
import business.IUtilisateurMetier;
import javax.faces.model.DataModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Damien
 */
public class TestHib {
    
    public TestHib() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testDAO() {

        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        IUtilisateurMetier util;
        util = (IUtilisateurMetier)appContext.getBean("utilisateurMetier");

        ILivreMetier liv;
        liv = (ILivreMetier)appContext.getBean("livreMetier");
        /**
          select 
         */
        Utilisateur user2 = util.findByUtilisateurId("1");
        System.out.println(user2);

        /*
        List lLivre2 = liv.findAll();
        for(Iterator it = lLivre2.iterator(); it.hasNext();){
            Livre l = (Livre) it.next();
            System.out.println(l);
        }
        LivreBean livre2 = new LivreBean();
        DataModel lLivre = livre2.getListeLivres();
        for(Iterator it = lLivre.iterator(); it.hasNext();){
            Livre l = (Livre) it.next();
            System.out.println(l);
        }
        */
        
        int a = liv.getNbLivres();
        System.out.println(a);
        
        System.out.println("Done");
    }
}
