package com.Rb.Repository;

import com.Rb.model.Accept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcceptRepository extends JpaRepository<Accept, Integer> {
}
