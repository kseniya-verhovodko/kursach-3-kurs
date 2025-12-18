package com.symbiosis.kvmode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.symbiosis.kvmode.model.Master;
import com.symbiosis.kvmode.service.MasterService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MasterController {

    @Autowired
    MasterService masterService;

    @PostMapping("/master")
    public ResponseEntity<Master> add(@RequestBody Master master) {
        Master savedMaster = masterService.save(master);
        return new ResponseEntity<Master>(savedMaster, HttpStatus.CREATED);
    }

    @GetMapping("/master/{email}/{password}")
    public ResponseEntity<Master> login(@PathVariable("email") String email,
                                        @PathVariable("password") String password) {
        Master master = masterService.login(email, password);
        return new ResponseEntity<Master>(master, HttpStatus.OK);
    }
}