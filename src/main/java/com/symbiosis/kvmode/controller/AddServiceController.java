package com.symbiosis.kvmode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.symbiosis.kvmode.model.AddService;
import com.symbiosis.kvmode.service.AddServiceService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AddServiceController {

    @Autowired
    private AddServiceService serviceService;

    // Get all services
    @GetMapping("/services")
    public List<AddService> getAllServices() {
        return serviceService.getAllServices();
    }
    
    @GetMapping("/services/count")
    public long getServiceCount() {
        return serviceService.getServiceCount();
    }

    // Add a new service
    @PostMapping("/services")
    public ResponseEntity<AddService> addService(@RequestBody AddService service) {
    	AddService savedService = serviceService.saveService(service);
        return new ResponseEntity<>(savedService, HttpStatus.CREATED);
    }
    
 // Update a service
    @PutMapping("/services/{id}")
    public ResponseEntity<AddService> updateService(@PathVariable("id") int id, @RequestBody AddService service) {
        AddService updatedService = serviceService.updateService(id, service);
        return new ResponseEntity<>(updatedService, HttpStatus.OK);
    }

    // Get a service by ID
    @GetMapping("/services/{id}")
    public ResponseEntity<AddService> getServiceById(@PathVariable("id") int id) {
        AddService service = serviceService.getServiceById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    // Delete a service
    @DeleteMapping("/services/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable("id") int id) {
        serviceService.deleteService(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
