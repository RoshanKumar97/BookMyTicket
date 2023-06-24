package com.bmt.bookmyticket.repository;

import com.bmt.bookmyticket.model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long>, JpaSpecificationExecutor<TicketEntity> {

}