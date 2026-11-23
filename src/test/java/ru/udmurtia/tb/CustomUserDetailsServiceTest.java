package ru.udmurtia.tb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class CustomUserDetailsServiceTest {

    @Test
    void generatePasswordHash() {
        org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder encoder =
                new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
        System.out.println("=======================================");
        System.out.println("ХЭШ ДЛЯ ПАРОЛЯ admin: " + encoder.encode("admin"));
        System.out.println("=======================================");
    }
}
