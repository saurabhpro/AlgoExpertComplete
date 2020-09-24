package interviewq.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q15_CaesarCypherEncryptorTest {

    @Test
    void caesarCypherEncryptor() {
        final String cypherEncryptor = Q15_CaesarCypherEncryptor.caesarCypherEncryptor("xyz", 2);
        Assertions.assertEquals("zab", cypherEncryptor);

    }
}