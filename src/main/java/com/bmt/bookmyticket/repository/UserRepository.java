package com.bmt.bookmyticket.repository;

import com.bmt.bookmyticket.model.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

	boolean existsByMobile(String mobile);

	@Transactional
	void deleteByMobile(String mobile);
}