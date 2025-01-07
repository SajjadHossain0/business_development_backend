package com.business_development_backend.business_development_backend.TeamMember.Services;

import com.business_development_backend.business_development_backend.TeamMember.Entities.TeamMember;
import com.business_development_backend.business_development_backend.TeamMember.Repositories.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamMemberService {

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    public TeamMember saveTeamMember(TeamMember teamMember) {
        return teamMemberRepository.save(teamMember);
    }

    public List<TeamMember> getAllTeamMembers() {
        return teamMemberRepository.findAll();
    }

    public void deleteTeamMember(Long id) {
        teamMemberRepository.deleteById(id);
    }
}
