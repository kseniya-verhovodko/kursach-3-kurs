package com.symbiosis.kvmode.service;

import java.util.List;
import com.symbiosis.kvmode.model.AddService;

public interface AddServiceService {
    
    AddService saveService(AddService service);
    
    List<AddService> getAllServices();
    
    AddService getServiceById(int id);
    
    void deleteService(int id);

	AddService updateService(int id, AddService service);

	long getServiceCount();
        
}
