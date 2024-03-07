package com.openclassrooms.debugging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Given that a dragon's saddle size has been estimated")
class SaddleSizeReporterTest {
    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @DisplayName("When reported on it, then it should clearly communicate the size")
    @Test
    void report() {
        // Arrange
        int targetYear = 2019;
        int saddleSize = 2018;
        SaddleSizeReporter classUnderTest = new SaddleSizeReporter(targetYear, saddleSize);

        // Act
        classUnderTest.report();

        // Assert
        String actualReport = byteArrayOutputStream.toString();
        assertThat( actualReport,
                startsWith("En l'an 2019, les dragons nes en l'an 1 " +
                        "auront une taille de selle de 20.18 metres(2018.0 centimetres)"));
    }
}