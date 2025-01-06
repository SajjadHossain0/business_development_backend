package com.business_development_backend.business_development_backend.ManageMajorClints.Repositories;

import com.business_development_backend.business_development_backend.ManageMajorClints.Entities.MajorClint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MCRepository extends JpaRepository<MajorClint, Long> {
}
