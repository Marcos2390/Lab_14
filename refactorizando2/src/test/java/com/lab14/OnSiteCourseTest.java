package com.lab14;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de OnSiteCourse")
public class OnSiteCourseTest {

    private OnSiteCourse onSiteCourse;

    @BeforeEach
    void init() {
        onSiteCourse = new OnSiteCourse("Java", 30, "Aula 1");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Sala 1", "Sala 2", "Laboratorio B"})
    @Tag("smoke")
    @DisplayName("Aulas válidas")
    void testClassroom(String classroom) {
        onSiteCourse.setClassroom(classroom);
        assertEquals(classroom, onSiteCourse.getClassroom());
    }

    @Test
    @Tag("regression")
    @DisplayName("Aula inválida")
    void testInvalidClassroom() {
        assertThrows(IllegalArgumentException.class, () -> {
            onSiteCourse.setClassroom("");
        });
    }
}
