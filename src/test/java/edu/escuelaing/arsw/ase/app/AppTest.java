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


}