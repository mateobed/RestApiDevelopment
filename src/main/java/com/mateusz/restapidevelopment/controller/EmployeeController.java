package com.mateusz.restapidevelopment.controller;

import com.mateusz.restapidevelopment.entity.EmployeeEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("employee")
public class EmployeeController {

    static EntityManagerFactory entityManagerFactory;
    static EntityManager entityManager;
    static {
        entityManagerFactory =
                Persistence.createEntityManagerFactory("default");

    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public EmployeeEntity setEmployee(EmployeeEntity employee){
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        return employee;
    }
}
