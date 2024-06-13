package edu.escuelaing.arsw.ase.app;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @BeforeEach
    void setUp() {
        App.allFiles = new ArrayList<>();
        App.files = new ArrayList<>();
        App.res = new String[]{};
    }

    @Test
    void testSelectFiles_phy() throws Exception {
        String[] args = {"phy", "TestFile.java"};
        String xd = Paths.get(System.getProperty("user.dir") + "\\"+ "src\\test\\java\\edu\\escuelaing\\arsw\\ase\\app\\resources\\TestFile.java").toString();
        App.allFiles.add(Paths.get(xd));

        App.selectFiles(args);

        assertEquals(1, App.files.size());
        assertTrue(App.files.contains(xd));
        assertNotNull(App.res);
        assertNotEquals(0, App.res.length);
    }

    @Test
    void testSelectFiles_loc() throws Exception {
        String[] args = {"loc", "TestFile.java"};
        String xd = Paths.get(System.getProperty("user.dir") + "\\"+ "src\\test\\java\\edu\\escuelaing\\arsw\\ase\\app\\resources\\TestFile.java").toString();
        App.allFiles.add(Paths.get(xd));

        App.selectFiles(args);
        assertEquals(1, App.files.size());
        assertTrue(App.files.contains(xd));
        assertNotNull(App.res);
        assertNotEquals(0, App.res.length);
    }

    @Test
    void testSelectFiles_throwsExceptionForMultipleFiles() {
        String[] args = {"phy", "TestFile.java"};
        App.allFiles.add(Paths.get(System.getProperty("user.dir") + "\\"+ "src\\test\\java\\edu\\escuelaing\\arsw\\ase\\app\\resources\\TestFile.java"));
        App.allFiles.add(Paths.get(System.getProperty("user.dir") + "\\"+ "src\\test\\java\\edu\\escuelaing\\arsw\\ase\\app\\resources\\TestFile.java"));

        Exception exception = assertThrows(Exception.class, () -> App.selectFiles(args));
        assertEquals("There is more than 1 file with the same name", exception.getMessage());
    }

    @Test
    void testSelectFiles_throwsExceptionForNoFiles() {
        String[] args = {"phy", "TestFile.java"};

        Exception exception = assertThrows(Exception.class, () -> App.selectFiles(args));
        assertEquals("There is no more than 1 file with the same name", exception.getMessage());
    }

    @Test
    void testSelectFiles_throwsExceptionForInvalidArgument() {
        String[] args = {"invalid", "TestFile.java"};
        App.allFiles.add(Paths.get(System.getProperty("user.dir") + "\\"+ "src\\test\\java\\edu\\escuelaing\\arsw\\ase\\app\\resources\\TestFile.java"));

        Exception exception = assertThrows(Exception.class, () -> App.selectFiles(args));
        assertEquals("Argument error, should be \"phy\" or \"loc\" ", exception.getMessage());
    }

    @Test
    void testFileHasFourLOC() {
        // Path to the test file
        String filePath = Paths.get(System.getProperty("user.dir") + "\\"+ "src\\test\\java\\edu\\escuelaing\\arsw\\ase\\app\\resources\\Test.java").toString();
        
        // Calculate lines of code using Loc class
        String[] lines = Loc.calculate(filePath);
        
        // Assert the lines of code count
        assertEquals(Integer.toString(4), lines[lines.length-1]);
    }
}