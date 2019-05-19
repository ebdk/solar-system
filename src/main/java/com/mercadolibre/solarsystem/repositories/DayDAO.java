package com.mercadolibre.solarsystem.repositories;

import com.mercadolibre.solarsystem.entity.DayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayDAO extends JpaRepository<DayEntity, Long> {
}
