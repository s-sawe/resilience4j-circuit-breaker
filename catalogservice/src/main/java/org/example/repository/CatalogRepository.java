package org.example.repository;

import org.example.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CatalogRepository extends JpaRepository<Catalog, Integer> {

    List<Catalog> findByCategory(String category);
}
