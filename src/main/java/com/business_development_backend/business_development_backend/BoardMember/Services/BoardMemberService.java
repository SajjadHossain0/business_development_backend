package com.business_development_backend.business_development_backend.BoardMember.Services;

import com.business_development_backend.business_development_backend.BoardMember.Entities.BoardMember;
import com.business_development_backend.business_development_backend.BoardMember.Repositories.BoardMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardMemberService {

    @Autowired
    private BoardMemberRepository boardMemberRepository;

    public BoardMember saveBoardMember(BoardMember boardMember) {
        return boardMemberRepository.save(boardMember);
    }

    public List<BoardMember> getAllBoardMembers() {
        return boardMemberRepository.findAll();
    }

    public void deleteBoardMember(Long id) {
        boardMemberRepository.deleteById(id);
    }
}