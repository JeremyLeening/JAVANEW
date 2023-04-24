package com.ltp.workbookmovies;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkbookController {
    @GetMapping("/shows")
    public String getShows(){
        return "shows";
    }

}
