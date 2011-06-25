package com.csc.sfm.infra.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.csc.sfm.application.exception.NotYetImplementedException;
import com.csc.sfm.domain.User;
import com.csc.sfm.infra.repository.UserRepository;

@Repository("userRepository")
public class UserRepositoryImpl extends HibernateDaoSupport implements UserRepository {

  public UserRepositoryImpl() {
    // Null constructor
  }
  
  /*
   * HibernateDaoSupport requires a SessionFactory or an HibernateTemplate bean property.
   * The session factory is passed using the @qualifier annotation in the constructor because the method 
   * setSessionFactory(SessionFactory sessionFactory) in HibernateDaoSupport is declared as "final".
   * So it cannot been override.
   */
  @Autowired
  public UserRepositoryImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
    super.setSessionFactory(sessionFactory);
  }
  
  @Override
  public User getByUsername(String username) {
    throw new NotYetImplementedException();
  }

  @Override
  public void save(User user) {
    super.getHibernateTemplate().save(user);
  }

  @Override
  public void update(User user) {
    super.getHibernateTemplate().update(user);
  }

  @Override
  public void delete(User user) {
    super.getHibernateTemplate().delete(user);
  }
}
