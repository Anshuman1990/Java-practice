package com.practice.java8_17.database.neo4j;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

public class CRUD {
    private Driver driver = null;

    public CRUD() {
        this.driver = Connection.createConnection("bolt://localhost:7687", "neo4j", "password");
    }

    public static void main(String[] args) {
        CRUD crud = new CRUD();
        crud.SELECT();
    }

    private void SELECT() {
        try (Session session = this.driver.session()) {
            String greeting = session.readTransaction(tx -> {
                StatementResult result = tx.run("MATCH p=()-[r:ACTED_IN]->() RETURN p");
                return result.toString();
            });
            System.out.println(greeting);
        }
    }

    private void INSERT() {

    }

}
