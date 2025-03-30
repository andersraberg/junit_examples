package se.anders_raberg.junit_example7.test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertTrue;

class OSTest {

    @Test
    @EnabledOnOs(OS.WINDOWS)  // Runs only on Windows
    void testRunsOnlyOnWindows() {
        assertTrue(System.getProperty("os.name").toLowerCase().contains("win"));
    }

    @Test
    @EnabledOnOs(OS.LINUX)  // Runs only on Linux
    void testRunsOnlyOnLinux() {
        assertTrue(System.getProperty("os.name").toLowerCase().contains("linux"));
    }

    @Test
    @DisabledOnOs(OS.MAC)  // Skips this test on macOS
    void testDisabledOnMac() {
        assertTrue(true);
    }
}
