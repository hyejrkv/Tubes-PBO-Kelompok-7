package com.tubespbo.carDealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tubespbo.carDealer.models.Pabrikan;

@Repository
public interface PabrikanRepository extends JpaRepository<Pabrikan, Integer> {
}
