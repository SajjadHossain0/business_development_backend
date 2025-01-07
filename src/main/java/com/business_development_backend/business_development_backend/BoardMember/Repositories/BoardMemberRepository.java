package com.business_development_backend.business_development_backend.BoardMember.Repositories;

import com.business_development_backend.business_development_backend.BoardMember.Entities.BoardMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardMemberRepository extends JpaRepository<BoardMember, Long> {
}
