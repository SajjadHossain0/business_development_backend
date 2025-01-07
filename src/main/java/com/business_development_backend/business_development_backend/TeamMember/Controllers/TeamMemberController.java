package com.business_development_backend.business_development_backend.TeamMember.Controllers;

import com.business_development_backend.business_development_backend.TeamMember.Entities.TeamMember;
import com.business_development_backend.business_development_backend.TeamMember.Services.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
@CrossOrigin
public class TeamMemberController {

    @Autowired
    private TeamMemberService teamMemberService;

    // Add a team member
    @PostMapping("/add")
    public ResponseEntity<TeamMember> addTeamMember(@RequestBody TeamMember teamMember) {
        TeamMember savedTeamMember = teamMemberService.saveTeamMember(teamMember);
        return ResponseEntity.ok(savedTeamMember);
    }

    // Get all team members
    @GetMapping("/get-all")
    public ResponseEntity<List<TeamMember>> getAllTeamMembers() {
        List<TeamMember> teamMembers = teamMemberService.getAllTeamMembers();
        return ResponseEntity.ok(teamMembers);
    }

    // Delete a team member
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTeamMember(@PathVariable Long id) {
        teamMemberService.deleteTeamMember(id);
        return ResponseEntity.ok("Team member deleted successfully!");
    }
}
