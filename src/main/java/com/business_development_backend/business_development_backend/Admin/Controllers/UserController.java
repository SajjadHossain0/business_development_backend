package com.business_development_backend.business_development_backend.Admin.Controllers;

import com.business_development_backend.business_development_backend.Admin.Repositories.UserRepository;
import com.business_development_backend.business_development_backend.Admin.Services.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private UserRepository userRepository;



}
