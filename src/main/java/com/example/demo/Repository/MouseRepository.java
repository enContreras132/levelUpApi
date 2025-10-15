    package com.example.demo.Repository;

    import com.example.demo.Model.MouseModel;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface MouseRepository extends JpaRepository<MouseModel, Integer> {

    }
