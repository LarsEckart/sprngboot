package com.larseckart.sprng;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SprngApplication.class)
@TestPropertySource("classpath:application.properties")
class MyDaoTest {

  @Autowired MyDao myDao;

  @Test
  void name() {
    myDao.run();
  }
}
