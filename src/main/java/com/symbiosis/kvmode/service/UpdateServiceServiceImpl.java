package com.symbiosis.kvmode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.symbiosis.kvmode.exception.ResourceNotFoundException;
import com.symbiosis.kvmode.model.UpdateService;
import com.symbiosis.kvmode.repository.UpdateServiceRepository;

@Service
public class UpdateServiceServiceImpl implements UpdateServiceService {

    @Autowired
    private UpdateServiceRepository serviceRepo;

    @Override
    public UpdateService saveService(UpdateService service) {
        return serviceRepo.save(service);
    }

    @Override
    public List<UpdateService> getAllServices() {
        return serviceRepo.findAll();
    }

    @Override
    public UpdateService getServiceById(int id) {
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
    public UpdateService updateService(int id, UpdateService service) {
        UpdateService existingService = serviceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service not found with id " + id));
        
        existingService.setCategory(service.getCategory());
        existingService.setServiceName(service.getServiceName());
        existingService.setServiceCost(service.getServiceCost());
        
        return serviceRepo.save(existingService);
    }

    @Override
    public List<UpdateService> getServicesByCategory(String category) {
        return serviceRepo.findAllByCategory(category);
    }

    @Override
    public UpdateService getServiceByName(String serviceName) {
        return serviceRepo.findByServiceName(serviceName);
    }
    
    @Override
	public long getCount() {
		// TODO Auto-generated method stub
		return serviceRepo.count();
	}

}
