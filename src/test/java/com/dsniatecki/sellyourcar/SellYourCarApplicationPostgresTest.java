package com.dsniatecki.sellyourcar;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("postgres")
@RunWith(SpringRunner.class)
@SpringBootTest
@DisplayName("SellYourCarApplication - Integration Test")
public class SellYourCarApplicationPostgresTest {

    @Test
    @DisplayName("Loading Context Test [ PostgreSQL DB ]")
    public void contextLoads() {
    }

}
