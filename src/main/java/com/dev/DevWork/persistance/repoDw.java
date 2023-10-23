package com.dev.DevWork.persistance;

import com.dev.DevWork.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repoDw extends JpaRepository<Persona, Long> {
}
