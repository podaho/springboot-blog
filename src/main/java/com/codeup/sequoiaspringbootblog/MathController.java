package com.codeup.sequoiaspringbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{x}/and/{y}")
    @ResponseBody
    public int add(@PathVariable String x, @PathVariable String y) {
        int xNum = Integer.parseInt(x);
        int yNum = Integer.parseInt(y);
        return xNum+yNum;
    }

    @GetMapping("/subtract/{x}/from/{y}")
    @ResponseBody
    public int subtract(@PathVariable String x, @PathVariable String y) {
        int xNum = Integer.parseInt(x);
        int yNum = Integer.parseInt(y);
        return yNum-xNum;
    }

    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public int multiply(@PathVariable String x, @PathVariable String y) {
        int xNum = Integer.parseInt(x);
        int yNum = Integer.parseInt(y);
        return yNum*xNum;
    }

    @GetMapping("/divide/{x}/by/{y}")
    @ResponseBody
    public float divide(@PathVariable String x, @PathVariable String y) {
        int xNum = Integer.parseInt(x);
        int yNum = Integer.parseInt(y);
        return ((float) xNum)/yNum;
    }
}
