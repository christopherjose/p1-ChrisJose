package com.github.ChrisJose.posSystem;

import com.datastax.oss.driver.api.core.CqlSession;
import com.github.ChrisJose.posSystem.Connection.Connection;
import com.github.ChrisJose.posSystem.Model.CustomerRepository;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitTest {

@Test
public void runConnection() {
    Connection connection = new Connection();
    connection.run();
    connection.close();
}


}