package com.wordpress.bmadi.belajar.hibernate.main;

import com.wordpress.bmadi.belajar.hibernate.model.HibernateUtil;
import com.wordpress.bmadi.belajar.hibernate.model.Person;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        System.out.println("Demo Belajar Hibernate Sederhana");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Person p = new Person();
        p.setName("Madi Andi");
        p.setPassword("Admin");
        session.save(p);

        session.getTransaction().commit();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        Query querySelect = session.createQuery("from Person");
        List<Person> persons = querySelect.list();
        for (Person person : persons) {
            System.out.println("ID : " + person.getId());
            System.out.println("Nama : " + person.getName());
            System.out.println("Password : " + person.getPassword());
        }
        session.close();  
    }
}
