package com.bmt.bookmyticket.repository;

import com.bmt.bookmyticket.model.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity, Long>, JpaSpecificationExecutor<TheaterEntity> {

}