package com.Junit.Sampletest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.Junit.Sampletest.Sample.User;

public class AssertionsDemo {

  User user;
  
  @Test
  void standardAssertions() {
      assertEquals(2, 2);
      assertEquals(4, 4, "The optional assertion message is now the last parameter.");
      assertTrue(2 == 2, () -> "Assertion messages can be lazily evaluated -- "
              + "to avoid constructing complex messages unnecessarily.");
  }

  @Test
  void groupedAssertions() {
      assertAll("user",
          () -> assertEquals("anit", user.getName()),
          () -> assertEquals("9992455552", user.getPhone()),
          () -> assertEquals("Bangalore", user.getAddress())
      );
  }

  @Test
  void dependentAssertions() {
     
      assertAll("properties",
          () -> {
              String name = user.getName();
              assertNotNull(name);

              assertAll("user name",
                  () -> assertTrue(name.startsWith("J")),
                  () -> assertTrue(name.endsWith("n"))
              );
          },
          () -> {
           
              String address = user.getAddress();
              assertNotNull(address);

              assertAll("last name",
                  () -> assertTrue(address.startsWith("Ban")),
                  () -> assertTrue(address.contains("india"))
              );
          }
      );
  }

  @Test
  void exceptionTesting() {
      Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
          throw new IllegalArgumentException("user not found");
      });
      assertEquals("wrong details", exception.getMessage());
  }
}
