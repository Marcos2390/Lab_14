package com.lab14;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests de OnlineCourse")
public class OnlineCourseTest {

    private OnlineCourse onlineCourse;

    @BeforeEach
    void init() {
        onlineCourse = new OnlineCourse("Java", 40, "Udemy");
    }

    @ParameterizedTest
    @CsvSource({
            "Coursera",
            "Bios",
            "Udemy"
    })
    @Tag("smoke")
    @DisplayName("Cambio de plataforma")
    void testSetPlatform(String platform) {
        onlineCourse.setPlatform(platform);
        assertEquals(platform, onlineCourse.getPlatform());
    }

    @Test
    @Tag("regression")
    @DisplayName("Plataforma inválida")
    void testSetPlatformInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            onlineCourse.setPlatform("");
        });
    }
}
