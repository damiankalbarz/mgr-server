package com.example.mgr_server.repository;


import com.example.mgr_server.entity.Osoba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsobaRepository extends JpaRepository<Osoba, Long> {
}