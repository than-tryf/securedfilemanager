package com.csc.sfm.infra.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.csc.sfm.domain.User;
import com.csc.sfm.infra.factory.UserFactory;
import com.csc.sfm.infra.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-context.xml"})
public class UserRepositoryImplTest extends AbstractTransactionalJUnit4SpringContextTests {

  @Autowired
  private UserRepository underTest;

  @Autowired
  private UserFactory userFactory;
    
  /*
   * getById
   */
  @Test
  public void getById_withMatchingUser_isOK() {
    User actual = underTest.getById(1);
    assertNotNull(actual);
    assertEquals("jeremy", actual.getUsername());
    assertEquals("1", actual.getPassword());
    assertEquals(true, actual.isActivated());
  }
  
  /*
   * getByUsername
   */
  
  @Test
  public void getByUsername_withMatchingUser_isOK() {
    User actual = underTest.getByUsername("jeremy");
    assertNotNull(actual);
    assertEquals("jeremy", actual.getUsername());
    assertEquals("1", actual.getPassword());
    assertEquals(true, actual.isActivated());
  }

  @Test
  public void getByUsername_withUngoundUser_isOK() {
    User actual = underTest.getByUsername("XXX");
    assertNull(actual);
  }
  
  /*
   * save
   */
  
  @Test
  @Transactional
  public void save_inexistantUser_isOK() {
    // Preparation
    List<User> initialListOfUsers = underTest.findAllUsers();
    int initialCount = initialListOfUsers.size();
    
    // Execution
    User user = userFactory.createUser(null, "krypto", "superdog", null, null, true, null, null);
    underTest.save(user);
    
    // Validation
    List<User> actualListOfUsers = underTest.findAllUsers();
    int actualCount = actualListOfUsers.size();

    assertEquals(initialCount + 1, actualCount);
    User persistedUser = underTest.getByUsername("krypto");
    assertNotNull(persistedUser);
    assertNotNull(persistedUser.getId());
  }
  
  @Test
  @Transactional
  public void save_userWithExistantUsername_shouldThowAnException() {
    // Preparation
    User user1 = userFactory.createUser(null, "krypto", "superdog", null, null, true, null, null);
    User user2 = userFactory.createUser(null, "krypto", "XXX", null, null, true, null, null); // user2 has same username than user1
    underTest.save(user1);
    
    // Execution
    try {
      underTest.save(user2);
      Assert.fail("Expected exception");
    } catch (JpaSystemException jpae) {
      // Validation
      System.out.println("Success: expected exception well occured !");
    } catch (Exception e) {
      Assert.fail("Expected JpaSystemException exception but get another type of exception");
    }
  }
}
