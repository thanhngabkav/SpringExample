package com.example.demo.webController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by THANH NGA on 7/3/2017.
 */

@Controller
@RequestMapping("/web")
public class WebHelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String Index(Model model){
        model.addAttribute("name","Admin");
        return "index";
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String Form(){
        return "form";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(Model model, @RequestParam("file")MultipartFile file){
        String fileLocation = "F://";
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(fileLocation+file.getOriginalFilename());
            Files.write(path,bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/web/hello";
    }
}
