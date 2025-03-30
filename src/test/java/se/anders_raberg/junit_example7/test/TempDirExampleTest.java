package se.anders_raberg.junit_example7.test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class TempDirExampleTest {

    @Test
    void testWriteAndReadFile(@TempDir Path tempDir) throws IOException {
        // Create a new file inside the temporary directory
        Path tempFile = tempDir.resolve("testFile.txt");

        // Write some content to the file
        String content = "Hello, JUnit!";
        Files.writeString(tempFile, content);

        // Read the content back
        String readContent = Files.readString(tempFile);

        // Assert that the written and read content are the same
        assertEquals(content, readContent);

        // Ensure the file actually exists
        assertTrue(Files.exists(tempFile));
    }
}
