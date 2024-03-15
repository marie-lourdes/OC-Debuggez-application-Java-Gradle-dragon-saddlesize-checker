package com.openclassrooms.debugging;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Given that we have a DragonSaddleSizeEstimator")
public class DragonSaddleSizeEstimatorIntegrationTest {

    @DisplayName("When the year is 2020 Then the saddle size should be 20.19 meters")
    @Test
    public void estimateSaddleSizeInCentiMeters_shouldReturnTwentyPointNineteenMeters_whenCalculatingTheSizeIn2020() throws Exception {
        int targetYear = 2020;
        // ARRANGE
        DragonSaddleSizeEstimator estimator = DragonSaddleSizeEstimator.INSTANCE;

        // Act
        Double expectedSaddleSize = DragonSaddleSizeEstimator.INSTANCE.estimateSaddleSizeInCentiMeters(targetYear);

        // Assert
        assertThat(expectedSaddleSize, is(equalTo(2019.0)));
    }
}

