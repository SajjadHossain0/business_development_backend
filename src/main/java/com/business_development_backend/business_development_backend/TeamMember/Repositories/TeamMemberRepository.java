package com.business_development_backend.business_development_backend.TeamMember.Repositories;

import com.business_development_backend.business_development_backend.TeamMember.Entities.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
}
