package com.crmsystem.registration.repository;

import com.crmsystem.registration.entity.UserRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<UserRegistry,Long> {

    UserRegistry findByEmail(String email);

}
