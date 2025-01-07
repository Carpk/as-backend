package com.thekleinbottle.as_backend.domain;



import org.springframework.data.repository.CrudRepository;

public interface AssetRepository extends CrudRepository <Asset, Long> {

    Asset findByNumber(String number);
}
