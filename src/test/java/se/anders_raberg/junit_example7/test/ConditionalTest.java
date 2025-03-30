package se.anders_raberg.junit_example7.test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.Test;

class ConditionalTest {

    @Test
    @EnabledIfSystemProperty(named = "env", matches = "dev")
    void testOnlyRunsOnDev() {
        // This test will only run if "-Denv=dev" is set
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "CI", matches = "true")
    void testDisabledOnCI() {
        // This test will be skipped if running in a CI pipeline
    }
}
