package com.openclassrooms.debugging;

import com.openclassrooms.debugging.exception.InvalidSaddleSizeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Given that we have a saddle size validator ")
class DragonSaddleSizeVerifierTest {

    DragonSaddleSizeVerifier verifierUnderTest = new DragonSaddleSizeVerifier();

    @Test
    @DisplayName("When we validate a positive saddle size, then we do not expect an exception to be thrown")
    public void verify_shouldVerify_() {
        Assertions.assertDoesNotThrow(() -> {
            verifierUnderTest.verify(2019.0);
        });
    }

    @Test
    @DisplayName("When we validate a negative saddle size, then we expect an InvalidSaddleSizeException")
    public void verify_shouldThrowAnInvalidSaddleSizeException_forNegativeSaddleSizes() {
        Assertions.assertThrows(InvalidSaddleSizeException.class, ()->{
            verifierUnderTest.verify(-1.0);
        });
    }

    @Test
    @DisplayName("When we validate saddle size of zero, then we expect an InvalidSaddleSizeException")
    public void verify_shouldThrowAnInvalidSaddleSizeException_forZeroSaddleSizes() {
        Assertions.assertThrows(InvalidSaddleSizeException.class, ()->{
            verifierUnderTest.verify(0.0);
        });
    }

    @Test
    @DisplayName("When we validate a null saddle size, then we expect an InvalidSaddleSizeException")
    public void verify_shouldThrowAnInvalidSaddleSizeException_forNullSaddleSizes() {
        Assertions.assertThrows(InvalidSaddleSizeException.class, ()->{
            verifierUnderTest.verify(null);
        });
    }

}