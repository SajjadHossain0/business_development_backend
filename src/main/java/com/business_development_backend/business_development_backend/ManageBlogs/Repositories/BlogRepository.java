package com.business_development_backend.business_development_backend.ManageBlogs.Repositories;

import com.business_development_backend.business_development_backend.ManageBlogs.Entities.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blogs, Long> {
}
