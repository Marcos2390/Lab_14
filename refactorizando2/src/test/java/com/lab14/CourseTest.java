package com.lab14;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Tests de Course")
public class CourseTest {

    private Course course;

    @BeforeAll
    static void initAll() {
        System.out.println(" Iniciando TODOS los tests de Course");
    }

    @AfterAll
    static void endAll() {
        System.out.println("Finalizando TODOS los tests de Course");
    }

    @BeforeEach
    void init() {
        course = new Course("Java", 40);
        System.out.println("Antes de cada test");
    }

    @AfterEach
    void tearDown() {
        course = null;
        System.out.println("Después de cada test");
    }

    @Test
    @Order(1)
    @Tag("smoke")
    @DisplayName("Nombre correcto del curso")
    void testGetName() {
        assertEquals("Java", course.getName());
    }

    @ParameterizedTest
    @MethodSource("duracionesValidas")
    @Order(2)
    @Tag("regression")
    @DisplayName("Duraciones válidas con MethodSource")
    void testSetDurationMethodSource(int duration) {
        course.setDuration(duration);
        assertEquals(duration, course.getDuration());
    }

    static Stream<Integer> duracionesValidas() {
        return Stream.of(10, 20, 60, 100);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @Order(3)
    @Tag("regression")
    @DisplayName("Nombre inválido: null o vacío")
    void testSetNameNullOrEmpty(String name) {
        assertThrows(IllegalArgumentException.class, () -> {
            course.setName(name);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "Python,50",
            "Spring,60",
            "Docker,20"
    })
    @Tag("smoke")
    @DisplayName("Datos con CSV Source")
    void testSettersCsvSource(String name, int duration) {
        course.setName(name);
        course.setDuration(duration);
        assertEquals(name, course.getName());
        assertEquals(duration, course.getDuration());
    }
}
