package com.example.demo.Repository;

import com.example.demo.Model.NotebookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotebookRepository extends JpaRepository<NotebookModel, Integer> {
}
