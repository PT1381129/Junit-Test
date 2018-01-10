package com.Junit.Sampletest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Junit.Sampletest.Sample.Calculator;
import com.Junit.Sampletest.Sample.User;
import com.Junit.Sampletest.Sample.UserDemo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTestApplicationTests {

  UserDemo userDemo;

  @Test
  public void createAndSetDetails() {

    // String user = "{name:Anit,address:Bangalore,phone:88755555}";

    User user = new User();
    user.setName("Anit Kumar");
    user.setAddress("Bangalore");
    
    user.setName("8844555");

    Assert.assertEquals(user, userDemo.userDetails());
    System.out.println("Suite Test 1 is successful " + userDemo.userDetails());
  }

  @Test
  public void contextLoads() {
  }

  @Test
  void myFirstTest() {
    assertEquals(2, 1 + 1, "2 should be equals to 1+1");
  }

  @BeforeAll
  static void initAll() {

  }

  @BeforeEach
  void init() {
  }

  @Test
  void succeedingTest() {
  }

  @Test
  void failingTest() {
    fail("a failing test");
  }

  @Test
  @Disabled("for demonstration purposes")
  void skippedTest() {
    // not executed
  }

  @AfterEach
  void tearDown() {
  }

  @AfterAll
  static void tearDownAll() {
  }

  @Test
  public void add() {
    Calculator calculator = new Calculator();
    assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
  }
}
