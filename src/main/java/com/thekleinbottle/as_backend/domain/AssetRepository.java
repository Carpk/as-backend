package com.thekleinbottle.as_backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AssetRepository extends CrudRepository <Asset, Long> {

    Asset findByNumber(@Param("number") String number);

    List<Asset> findByModel(String model);
}
