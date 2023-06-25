package com.bmt.bookmyticket.repository;

import com.bmt.bookmyticket.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long>, JpaSpecificationExecutor<MovieEntity> {

    boolean existsByName(String name);

    MovieEntity findByName(String name);
}