package com.pivotal.brighton.controller;

import com.pivotal.brighton.controller.StatusController;
import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by pivotal on 1/25/16.
 */
public class StatusControllerTest {
    StatusController statusController = new StatusController();

    @Test
    public void statusTest(){
        assertEquals(statusController.getStatus(), new ResponseEntity<String>("200",HttpStatus.OK));
    }
}