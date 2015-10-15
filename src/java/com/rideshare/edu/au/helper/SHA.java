/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rideshare.edu.au.helper;

/**
 * Reference: UTS online
 */
import java.security.*;
public class SHA {
    /**
     * Hash256 encode string 
     * @param data
     * @return
     * @throws NoSuchAlgorithmException 
     */
    public static String hash256(String data) throws NoSuchAlgorithmException {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(data.getBytes());
      return bytesToHex(md.digest());
    }
    /**
     * Turn Bytes into Hex
     * @param bytes
     * @return 
     */
    public static String bytesToHex(byte[] bytes) {
      StringBuffer result = new StringBuffer();
      for (byte byt : bytes) {
        result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
      }
      return result.toString();
    }
}