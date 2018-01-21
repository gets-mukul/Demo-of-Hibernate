package com.telusko.DemoHib;


import org.hibernate.Transaction;

import org.hibernate.service.ServiceRegistry;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
        Alien telusko = new Alien();
        AlienName an = new AlienName();
        an.setFname("Amit");
        an.setMname("Kumar");
        an.setLname("shah");
        telusko.setAname(an);
        telusko.setAid(104);
        telusko.setColor("red");
        
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        ServiceRegistry reg =  new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory(reg) ; //deplicated method 
        
         Session session =sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(telusko);
        
        tx.commit();
    }
}
