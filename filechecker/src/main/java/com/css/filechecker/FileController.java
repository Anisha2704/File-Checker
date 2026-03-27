package com.css.filechecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class FileController {

    @Autowired
    private HashService hashService;

    @PostMapping("/hash")
    public String computeHash(@RequestParam("file") MultipartFile file) throws Exception {
        return hashService.getSHA256(file.getInputStream());
    }

    @PostMapping("/compare")
    public String compareHash(@RequestParam("file") MultipartFile file,
                              @RequestParam("hash") String userHash) throws Exception {
        String generated = hashService.getSHA256(file.getInputStream());
        if (generated.equalsIgnoreCase(userHash)) {
            return "✅ File is NOT modified (Integrity OK)";
        } else {
            return "❌ File has been MODIFIED";
        }
    }
}

