package com.pivotal.brighton;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by pivotal on 1/25/16.
 */
public class StatusTest {

    StatusController statusController = new StatusController();

    @Test
    public void statusTest()
    {

        assertEquals(statusController.getStatus(), new ResponseEntity<String>("200",HttpStatus.OK));
    }
}


