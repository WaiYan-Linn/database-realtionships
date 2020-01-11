package com.example.myormproject.repository;

import com.example.myormproject.domain.Cage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CageRepository extends JpaRepository<Cage,Integer> {
}
