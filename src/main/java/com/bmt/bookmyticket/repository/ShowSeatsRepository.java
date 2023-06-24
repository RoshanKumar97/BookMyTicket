package com.bmt.bookmyticket.repository;

import com.bmt.bookmyticket.model.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatsRepository extends JpaRepository<ShowSeatsEntity, Long>, JpaSpecificationExecutor<ShowSeatsEntity> {

}