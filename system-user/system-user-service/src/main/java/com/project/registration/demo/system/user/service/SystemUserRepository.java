package com.project.registration.demo.system.user.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.project.registration.demo.system.user.mapping.SystemUser;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Long>, JpaSpecificationExecutor<SystemUser> {

}
