package com.business_development_backend.business_development_backend.BoardMember.Controllers;

import com.business_development_backend.business_development_backend.BoardMember.Entities.BoardMember;
import com.business_development_backend.business_development_backend.BoardMember.Services.BoardMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class BoardMemberController {

    @Autowired
    private BoardMemberService boardMemberService;

    // Add a board member
    @PostMapping("/add")
    public ResponseEntity<BoardMember> addBoardMember(@RequestBody BoardMember boardMember) {
        BoardMember savedBoardMember = boardMemberService.saveBoardMember(boardMember);
        return ResponseEntity.ok(savedBoardMember);
    }

    // Get all board members
    @GetMapping("/get-all")
    public ResponseEntity<List<BoardMember>> getAllBoardMembers() {
        List<BoardMember> boardMembers = boardMemberService.getAllBoardMembers();
        return ResponseEntity.ok(boardMembers);
    }

    // Delete a board member
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBoardMember(@PathVariable Long id) {
        boardMemberService.deleteBoardMember(id);
        return ResponseEntity.ok("Board member deleted successfully!");
    }
}
