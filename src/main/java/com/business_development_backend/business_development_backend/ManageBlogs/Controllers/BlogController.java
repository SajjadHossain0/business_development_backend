package com.business_development_backend.business_development_backend.ManageBlogs.Controllers;

import com.business_development_backend.business_development_backend.ManageBlogs.Entities.Blogs;
import com.business_development_backend.business_development_backend.ManageBlogs.Services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin
public class BlogController {

    @Autowired
    private BlogService blogService;

    // Add a new blog post with a BLOB image
    @PostMapping("/add")
    public ResponseEntity<Blogs> addBlogPost(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("date") String date,
            @RequestParam("authorName") String authorName,
            @RequestParam("image") MultipartFile image) {
        try {
            // Create a new Blogs object and set its fields
            Blogs blogs = new Blogs();
            blogs.setTitle(title);
            blogs.setContent(content);
            blogs.setDate(date);
            blogs.setAuthorName(authorName);
            blogs.setImage(image.getBytes());

            // Save the blog post
            Blogs savedBlogPost = blogService.saveBlogPost(blogs);
            return ResponseEntity.ok(savedBlogPost);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Get all blog posts
    @GetMapping("/get-all")
    public ResponseEntity<List<Blogs>> getAllBlogPosts() {
        List<Blogs> blogPosts = blogService.getAllBlogPosts();
        return ResponseEntity.ok(blogPosts);
    }

    // Get a single blog post by ID
    @GetMapping("/{id}")
    public ResponseEntity<Blogs> getBlogPostById(@PathVariable Long id) {
        return blogService.getBlogPostById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}