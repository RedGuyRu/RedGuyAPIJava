package ru.redguy.redguyapi;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {
    @NotNull
    public static String md5(@NotNull String st) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();

        BigInteger bigInt = new BigInteger(1, digest);
        StringBuilder md5Hex = new StringBuilder(bigInt.toString(16));

        while( md5Hex.length() < 32 ){
            md5Hex.insert(0, "0");
        }

        return md5Hex.toString();
    }
}
