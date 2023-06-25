package com.bmt.bookmyticket.repository;

import com.bmt.bookmyticket.model.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity, Long>, JpaSpecificationExecutor<ShowEntity> {

    List<ShowEntity> findAllByMovieId(long movieId);
}