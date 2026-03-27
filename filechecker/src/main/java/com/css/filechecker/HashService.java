package com.css.filechecker;

import org.springframework.stereotype.Service;
import java.io.InputStream;
import java.security.MessageDigest;

@Service
public class HashService {
    public String getSHA256(InputStream input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1) {
            md.update(buffer, 0, bytesRead);
        }
        byte[] hashBytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
