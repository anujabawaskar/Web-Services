package com.anuja.restws.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anuja.restws.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
