package com.business_development_backend.business_development_backend.ManageBlogs.Services;


import com.business_development_backend.business_development_backend.ManageBlogs.Entities.Blogs;
import com.business_development_backend.business_development_backend.ManageBlogs.Repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {


    @Autowired
    private BlogRepository blogRepository;

    public Blogs saveBlogPost(Blogs blogPost) {
        return blogRepository.save(blogPost);
    }

    public List<Blogs> getAllBlogPosts() {
        return blogRepository.findAll();
    }

    public Optional<Blogs> getBlogPostById(Long id) {
        return blogRepository.findById(id);
    }

    public void deleteBlogPostById(Long id) {
        blogRepository.deleteById(id);
    }

}
