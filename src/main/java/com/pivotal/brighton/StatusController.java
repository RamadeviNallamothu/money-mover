package com.pivotal.brighton;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import javax.xml.ws.BindingType;
import java.util.Map;
import java.lang.Object;


/**
 * Created by pivotal on 1/25/16.
 */
@RestController
public class StatusController {

//    @RequestMapping(path = "/",method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody ResponseEntity<String> getUnauthStatus()
//    {
//        return new ResponseEntity<String>("200",HttpStatus.OK);
//    }

    @RequestMapping(path = "/status",method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> getStatus()
    {
        return new ResponseEntity<String>("200",HttpStatus.OK);
    }


}
