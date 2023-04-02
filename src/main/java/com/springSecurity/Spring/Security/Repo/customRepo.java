package com.springSecurity.Spring.Security.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface customRepo extends JpaRepository<CustomUser,Integer> {


}
