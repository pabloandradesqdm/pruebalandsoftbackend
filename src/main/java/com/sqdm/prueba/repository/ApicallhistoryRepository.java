package com.sqdm.prueba.repository;

import com.sqdm.prueba.model.Apicallhistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApicallhistoryRepository extends JpaRepository<Apicallhistory, Integer>{
}
