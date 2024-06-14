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
        App.data = new ArrayList<>();
        App.resp = new ArrayList<>();
    }

    @Test
    void testSelectFiles() throws Exception {
        Path mockPath = Paths.get(System.getProperty("user.dir")+"\\resources\\mock.csv");
        App.allFiles.add(mockPath);

        App.selectFiles(new String[]{"mock.csv"});
        assertEquals(1, App.files.size());
        assertEquals(mockPath.toString(), App.files.get(0));
    }

    @Test
    void testConvert() {
        LinkedList<String> mockList = new LinkedList<>();
        mockList.add("Test");
        mockList.add("1.0");
        mockList.add("2.0");

        App.data.add(mockList);
        List<LinkedList<Double>> converted = App.convert();
        assertEquals(1, converted.size());
        assertEquals(1.0, converted.get(0).get(0));
        assertEquals(2.0, converted.get(0).get(1));
    }

    @Test
    void testGenerateLambdas() {
        App.generateLambdas();
        LinkedList<Double> testList = new LinkedList<>();
        testList.add(1.0);
        testList.add(2.0);
        testList.add(3.0);

        assertEquals("2.0", App.mean.operation(testList));
        assertEquals("1.0", App.deviation.operation(testList));
    }

    @Test
    void testGenerateResponse() {
        App.generateLambdas();

        LinkedList<String> mockList = new LinkedList<>();
        mockList.add("Test");
        mockList.add("1.0");
        mockList.add("2.0");
        mockList.add("3.0");

        App.data.add(mockList);
        App.generateResponse();

        assertEquals(2, App.resp.size()); // Includes header and data
        assertEquals("Mean", App.resp.get(0).get(0));
        assertEquals("2.0", App.resp.get(1).get(0));
        assertEquals("1.0", App.resp.get(1).get(1));
    }

    @Test
    void testIntegration() throws Exception {
        // Prepare files
        Path mockPath =Paths.get(System.getProperty("user.dir")+"\\resources\\mock.csv");
        App.allFiles.add(mockPath);

        // Select file
        App.selectFiles(new String[]{"mock.csv"});
        
        // Generate lambdas
        App.generateLambdas();
        
        // Generate response
        App.generateResponse();

        // Verify response
        assertEquals(4, App.resp.size());
        assertEquals("Mean", App.resp.get(0).get(0));
        assertEquals("550.6", App.resp.get(1).get(0));
        assertNotNull(App.resp.get(1).get(1));
    }

}