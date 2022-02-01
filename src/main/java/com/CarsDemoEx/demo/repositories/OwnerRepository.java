package com.CarsDemoEx.demo.repositories;

import com.CarsDemoEx.demo.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
