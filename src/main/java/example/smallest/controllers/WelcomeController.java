package example.smallest.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class WelcomeController {
    @Value("${env}")
    String env;
    @Value("${paths}")
    String path;

    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    String helloWorld() {
        return env;
    }

    @PostMapping("/upload")
    public String saveUser(
            @RequestParam("image") MultipartFile file) throws IOException {
        Path filepath = Paths.get(path, file.getOriginalFilename());

        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        } catch (Exception e) {

        }
        return "";
    }
}

