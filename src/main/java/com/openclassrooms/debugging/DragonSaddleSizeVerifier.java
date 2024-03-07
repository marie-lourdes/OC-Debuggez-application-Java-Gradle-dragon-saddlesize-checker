package com.openclassrooms.debugging;

import com.openclassrooms.debugging.exception.InvalidSaddleSizeException;

public class DragonSaddleSizeVerifier {

    public void verify(Double saddleSize) {
        if (null == saddleSize) {
            throw new InvalidSaddleSizeException("Taille de selle nulle inattendue");
        }

        if (saddleSize <= 0) {
            throw new InvalidSaddleSizeException("Taille de selle inattendue:" + saddleSize);
        }
    }
}
