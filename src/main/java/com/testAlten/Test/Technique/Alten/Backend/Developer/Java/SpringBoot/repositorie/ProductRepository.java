package com.testAlten.Test.Technique.Alten.Backend.Developer.Java.SpringBoot.repositorie;

import com.testAlten.Test.Technique.Alten.Backend.Developer.Java.SpringBoot.entitie.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
