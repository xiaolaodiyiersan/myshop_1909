package com.qf.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class PathExceptionController implements ErrorController {
    @RequestMapping("/error")
    public String PathErro(HttpServletResponse response ){
        int error = response.getStatus();
        switch (error){
            case 401 :
                return "401";
            case 402 :
                return "402";
            case 403 :
                return "403";
            case 404 :
                return "404";
        }
        return "myerror";
    }
    @Override
    public String getErrorPath() {
        return null;
    }
}
