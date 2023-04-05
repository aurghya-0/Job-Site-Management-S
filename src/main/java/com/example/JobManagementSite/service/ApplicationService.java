package com.example.JobManagementSite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JobManagementSite.dao.AppliRepo;
import com.example.JobManagementSite.model.Application;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private AppliRepo arepo;

    public Application createApplication(Application app) {
        arepo.save(app);
        return app;
    }

    public Application getApplicationById(int id) {
        return arepo.findById(id).orElse(new Application());
    }

    public void deleteApplicationById(int id) {
        arepo.deleteById(id);
    }
}
