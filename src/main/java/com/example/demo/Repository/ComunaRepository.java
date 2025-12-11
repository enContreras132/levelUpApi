package com.example.demo.Repository;

import com.example.demo.Model.ComunaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunaRepository extends JpaRepository<ComunaModel, Integer> {
}
