/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTOs.PersonDTO;
import DTOs.PersonsDTO;
import entities.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author jenso
 */
public class IPersonFacade {
    private static IPersonFacade instance;
    private static EntityManagerFactory emf;
    public static void main(String[] args) {
         emf = Persistence.createEntityManagerFactory("pu");      
    IPersonFacade facade = IPersonFacade.getIPersonFacade(emf);
    
    }
    public static IPersonFacade getIPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new IPersonFacade();
        }
        return instance;
    }
    private static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
  public PersonDTO addPerson(String fName, String lName, String phone){
      return null;
  }
  public PersonDTO deletePerson(int id){
      return null;
  }
      
          
  public PersonDTO getPerson(int id){
  EntityManager em = emf.createEntityManager(); 
        try {
            TypedQuery<Person> query = em.createQuery("Select p from Person p where p.id = :id", Person.class);
            query.setParameter("id", id); 
            return new PersonDTO(query.getSingleResult()); 
        }
        finally {
            em.close();
        }
  }
  public PersonsDTO getAllPersons(){
      EntityManager em = getEntityManager();
        
              try {
            TypedQuery<Person> query = em.createQuery("Select p from Person p", Person.class); 
            System.out.println(query.getResultList().size());
            //return new Gson().toJson(query.getResultList());
            List<Person> resultList = query.getResultList(); 
        
        
            return new PersonsDTO(resultList); 
              }
        finally {
            em.close();
        }
  }
  public PersonDTO editPerson(PersonDTO p){
      return null;
}

    
}
