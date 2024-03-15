package com.openclassrooms.debugging;

import com.openclassrooms.debugging.exception.InvalidSaddleSizeException;

public class DragonSaddleSizeVerifier {

    public void verify(Double saddleSize) {
        if (null == saddleSize) {
        	System.out.println("Taille de selle inattendue");
            throw new InvalidSaddleSizeException("Taille de selle nulle inattendue");
        }

        if (saddleSize <= 0) {
        	System.out.println("Taille de selle inattendue:" + saddleSize);
            throw new InvalidSaddleSizeException("Taille de selle inattendue:" + saddleSize);
        }
    }
}
