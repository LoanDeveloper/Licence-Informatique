package fr.greencodeinitiative.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

class AvoidSetConstantInBatchInsertTest {

    @Test
    void test() {
        CheckVerifier.newVerifier()
                .onFile("src/test/files/AvoidSetConstantInBatchUpdateCheck.java")
                .withCheck(new AvoidSetConstantInBatchUpdate())
                .verifyIssues();
    }

}