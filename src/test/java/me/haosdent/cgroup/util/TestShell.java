package me.haosdent.cgroup.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.*;

public class TestShell {

  private static final Logger LOG = LoggerFactory.getLogger(TestShell.class);

  @Before
  public void setUp() {}

  @After
  public void tearDown() {}

  @Test
  public void testExec() throws IOException {
    Shell shell = new Shell(null);
    String output = shell.exec("echo 0");
    assertTrue(output.equals("0\n"));
  }

  @Test
  public void testMount() {}

  @Test
  public void testUmount() {}
}
