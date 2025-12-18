package com.symbiosis.kvmode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.symbiosis.kvmode.exception.ResourceNotFoundException;
import com.symbiosis.kvmode.model.AddService;
import com.symbiosis.kvmode.repository.AddServiceRepository;

@Service
public class AddServiceServiceImpl implements AddServiceService {

    @Autowired
    private AddServiceRepository serviceRepo;

    @Override
    public AddService saveService(AddService service) {
        if (service.getCategory() == null || service.getSubcategory() == null) {
            throw new IllegalArgumentException("Category and Subcategory must be provided");
        }
        return serviceRepo.save(service);
    }


    @Override
    public List<AddService> getAllServices() {
        return serviceRepo.findAll();
    }

    @Override
    public AddService getServiceById(int id) {
        return serviceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service not found with id " + id));
    }

    @Override
    public void deleteService(int id) {
        serviceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service not found with id " + id));
        serviceRepo.deleteById(id);
    }


    @Override
    public AddService updateService(int id, AddService service) {
        AddService existingService = serviceRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Service not found with id " + id));

        existingService.setCategory(service.getCategory());
        existingService.setSubcategory(service.getSubcategory());
        existingService.setServiceName(service.getServiceName());
        existingService.setServiceCost(service.getServiceCost());

        return serviceRepo.save(existingService);
    }


    @Override
    public long getServiceCount() {
        return serviceRepo.count();
    }


}
