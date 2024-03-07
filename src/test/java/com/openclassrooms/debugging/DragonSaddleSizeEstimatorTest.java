package com.openclassrooms.debugging;

import com.openclassrooms.debugging.exception.InvalidSaddleSizeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@DisplayName("Given we have a saddle size estimatorUnderTest spell")
@ExtendWith(MockitoExtension.class)
class DragonSaddleSizeEstimatorTest {

    @Mock
    DragonSaddleSizeVerifier verifier;

    DragonSaddleSizeEstimator estimatorUnderTest;

    @BeforeEach
    public void setUp() {
        estimatorUnderTest = new DragonSaddleSizeEstimator();
        estimatorUnderTest.setYearOfBirth(1); // Dragon's should be born in 1 AD
        estimatorUnderTest.setCopyOfUniversalConstant(42); // 42 is the universal constant
        estimatorUnderTest.setVerifier(verifier);

    }

    @DisplayName("When estimating for a saddle size in the year 2 AD then the size is 2 centimeter")
    @Test
    public void estimateSaddleSize_shouldReturnASizeOfOne_forEarlyEraTwoAD() throws Exception {
        double estimatedSaddleSize = estimatorUnderTest.estimateSaddleSizeInCentiMeters(2);
        // A one year old dragon has a 1 cm saddle size
        assertThat(estimatedSaddleSize, is(equalTo(1.0)));
    }

    @DisplayName("When estimating for a saddle size in the year 2021 then the size is 20.2 meters")
    @Test
    public void estimateSaddleSize_shouldReturnTheTwentyPointTwo_forModernEraYear2021() throws Exception {
        double expectedSize = 2020.0;
        double estimatedSaddleSize = estimatorUnderTest.estimateSaddleSizeInCentiMeters(2021);
        assertThat(estimatedSaddleSize, is(equalTo(expectedSize)));
    }

    @DisplayName("When estimating for a negative saddle size in the year -2")
    @Test
    public void estimateSaddleSize_shouldFail_forYearsBeforeZero() throws Exception {
        doThrow(new InvalidSaddleSizeException("")).when(verifier).verify(0.0);

        // Check that an assertion is thrown
        Assertions.assertThrows(InvalidSaddleSizeException.class, () ->{
            double estimatedSaddleSize = estimatorUnderTest.estimateSaddleSizeInCentiMeters(-2);
        });
        verify(verifier).verify(0.0);
    }

}