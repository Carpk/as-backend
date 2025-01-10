package com.thekleinbottle.as_backend.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thekleinbottle.as_backend.domain.Asset;
import com.thekleinbottle.as_backend.domain.AssetRepository;

@RestController
public class AssetController {
    private final AssetRepository repository;

    public AssetController(AssetRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/assets")
    public Iterable<Asset> getAssets() {
        return repository.findAll();
    }
    
}
