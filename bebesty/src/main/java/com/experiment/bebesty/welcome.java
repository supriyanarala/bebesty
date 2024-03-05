package com.experiment.bebesty;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {

   @GetMapping("/welcome")
    public String getMessage(){
        return "Welcome";
    }
}
