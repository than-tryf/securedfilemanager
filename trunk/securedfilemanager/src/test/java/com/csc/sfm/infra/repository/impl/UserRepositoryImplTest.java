package com.csc.sfm.infra.repository.impl;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.csc.sfm.domain.User;
import com.csc.sfm.infra.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-context.xml"})
public class UserRepositoryImplTest {

  @Autowired
  @Qualifier("userRepository")
  private UserRepository underTest;

  @Test
  public void getByUsername_withMatchingUser_isOK() {
    User actual = underTest.getByUsername("jeremy");
    Assert.assertNotNull(actual);
    Assert.assertEquals("jeremy", actual.getUsername());
    Assert.assertEquals("1", actual.getPassword());
    Assert.assertEquals(true, actual.isActivated());
  }

  @Test
  public void getByUsername_withUngoundUser_isOK() {
    User actual = underTest.getByUsername("XXX");
    Assert.assertNotNull(actual);
    Assert.assertEquals("jeremy", actual.getUsername());
    Assert.assertEquals("1", actual.getPassword());
    Assert.assertEquals(true, actual.isActivated());
  }
}
