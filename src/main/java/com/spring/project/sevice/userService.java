package com.spring.project.sevice;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.Dao.UserDao;
import com.spring.project.entity.User;

@Service
public class userService {

  @Autowired
  HibernateTransactionManager hibernateTransactionManager;


  public void addUser(String name,String email){
    hibernateTransactionManager
    .getSessionFactory()
    .createEntityManager()
    .createQuery("INSERT INTO User(name,email) Values (?,?)")
    .setParameter(1, name)
    .setParameter(2, email).executeUpdate();
  }



  public List<User> getUsers(){
   EntityManager createEntityManager = hibernateTransactionManager
      .getSessionFactory()
      .createEntityManager();
      
  List<User> users = createEntityManager
    .createQuery("SELECT * FROM User").getResultList();

    return users;
  }


}
