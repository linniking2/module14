package org.dev.module14;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestThymeleafController {
    @GetMapping("/thymeleaf-test")
    public String thymeleafTest(){
        return "test";
        //http://localhost:8080/thymeleaf-test
    }
}
