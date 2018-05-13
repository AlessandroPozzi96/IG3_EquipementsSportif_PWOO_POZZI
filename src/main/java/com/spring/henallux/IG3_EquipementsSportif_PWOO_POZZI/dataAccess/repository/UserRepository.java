package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
    UserEntity findByUsername(String username);
}
