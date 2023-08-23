package com.Rb.Repository;

import com.Rb.model.Reject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RejectRepository extends JpaRepository<Reject,Integer> {
}
