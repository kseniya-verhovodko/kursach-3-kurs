package com.symbiosis.kvmode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.symbiosis.kvmode.model.UpdateService;
import com.symbiosis.kvmode.service.UpdateServiceService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UpdateServiceController {

    @Autowired
    private UpdateServiceService serviceService;

    // Get all services
    @GetMapping("/updateservices")
    public List<UpdateService> getAllServices() {
        return serviceService.getAllServices();
    }

    // Add a new service
    @PostMapping("/updateservices")
    public ResponseEntity<UpdateService> addService(@RequestBody UpdateService service) {
        UpdateService savedService = serviceService.saveService(service);
        return new ResponseEntity<>(savedService, HttpStatus.CREATED);
    }

    // Get a service by ID
    @GetMapping("/updateservices/{id}")
    public ResponseEntity<UpdateService> getServiceById(@PathVariable("id") int id) {
        UpdateService service = serviceService.getServiceById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    // Delete a service
    @DeleteMapping("/updateservices/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable("id") int id) {
        serviceService.deleteService(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Update a service
    @PutMapping("/updateservices/{id}")
    public ResponseEntity<UpdateService> updateService(@PathVariable("id") int id, @RequestBody UpdateService service) {
        UpdateService updatedService = serviceService.updateService(id, service);
        return new ResponseEntity<>(updatedService, HttpStatus.OK);
    }

    // Get services by category
    @GetMapping("/updateservices/category/{category}")
    public ResponseEntity<List<UpdateService>> getServicesByCategory(@PathVariable("category") String category) {
        List<UpdateService> services = serviceService.getServicesByCategory(category);
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    // Get a service by name
    @GetMapping("/updateservices/name/{serviceName}")
    public ResponseEntity<UpdateService> getServiceByName(@PathVariable("serviceName") String serviceName) {
        UpdateService service = serviceService.getServiceByName(serviceName);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }
}
