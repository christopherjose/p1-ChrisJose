package com.github.ChrisJose.posSystem.Connection;

import com.datastax.oss.driver.api.core.CqlSession;

public class Cassandra {

    private CqlSession session;

    public void connect() {
        session = CqlSession.builder().build();
    }
    public CqlSession getSession() { return this.session; }
    public void close() { session.close(); }

}

//source: https://www.baeldung.com/cassandra-datastax-java-driver