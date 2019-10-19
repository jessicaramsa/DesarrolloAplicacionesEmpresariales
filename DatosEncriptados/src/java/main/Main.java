package main;

import java.nio.charset.StandardCharsets;
import java.security.DigestException;



import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import lib.AES;
import lib.AesUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kp215
 */
public class Main {
    public static void main(String[] args) {
        AesUtil aes = new AesUtil(128, 1000);
        String encryptedData = "MGRkYzE1OWNiYjU1Njk1ZjkzN2NlYTRiZWJmNmJkODc6OmFhNzIzN2E1NTQ5NTY4MmE1ZjUwYTk0M2ZiYzZmZGUwOjoycStrdDdmemZ3OWlDN2IzRzRXQ2FBPT0=";
        String decryptedData =  new String(java.util.Base64.getDecoder().decode(encryptedData));
        System.out.println(aes.decrypt(decryptedData.split("::")[1], decryptedData.split("::")[0], "password", decryptedData.split("::")[2]));
    }
}
