package com.epam.park.repository;

import com.epam.park.model.Forester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForesterRepository extends JpaRepository<Forester, Long> {
}
