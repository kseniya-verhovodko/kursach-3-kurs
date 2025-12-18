package com.symbiosis.kvmode.model;

import jakarta.persistence.*;

@Entity
public class AddService {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String category;
    
    private String subcategory;

    private String serviceName;
    
    private double serviceCost;

    public AddService() {
        super();
    }

    public AddService(String category, String subcategory, String serviceName, double serviceCost ) {
        this.category = category;
        this.subcategory = subcategory;        
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }
}
