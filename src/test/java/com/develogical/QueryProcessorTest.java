package com.develogical;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class QueryProcessorTest {

  QueryProcessor queryProcessor = new QueryProcessor();

  @Test
  public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
    assertThat(queryProcessor.process("test"), is(""));
  }

  @Test
  public void knowsAboutShakespeare() throws Exception {
    assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
  }

  @Test
  public void knowsAboutYourName() throws Exception {
    assertThat(queryProcessor.process("What is your name?"), containsString("Diego"));
  }

  @Test
  public void knowsPlus() throws Exception {
    assertThat(queryProcessor.process("What is 76 plus 34?"), containsString("110"));
  }

  @Test
  public void knowsLargestNumber() throws Exception {
    assertThat(queryProcessor.process("Which of the following numbers is the largest: 87, 96, 51?"), containsString("96"));
  }

  @Test
  public void knowsMultipliedNumber() throws Exception {
    assertThat(queryProcessor.process("What is 47 multiplied by 70?"), containsString("3290"));
  }
}
