package com.business_development_backend.business_development_backend.BoardMember.Controllers;

import com.business_development_backend.business_development_backend.BoardMember.Entities.BoardMember;
import com.business_development_backend.business_development_backend.BoardMember.Services.BoardMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class BoardMemberController {

    @Autowired
    private BoardMemberService boardMemberService;

    @PostMapping("/add")
    public ResponseEntity<BoardMember> add(@RequestParam("image") MultipartFile image,
                                           @RequestParam("name") String name,
                                           @RequestParam("position") String position,
                                           @RequestParam("bio") String bio) throws IOException {

        BoardMember boardMember = new BoardMember();
        boardMember.setName(name);
        boardMember.setPosition(position);
        boardMember.setBio(bio);
        boardMember.setImage(image.getBytes());

        BoardMember saveBoardMEmber = boardMemberService.saveBoardMember(boardMember);

        return ResponseEntity.ok(saveBoardMEmber);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<BoardMember>> getAll() {
        List<BoardMember> boardMembers = boardMemberService.getAllBoardMembers();
        return ResponseEntity.ok(boardMembers);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BoardMember> delete(@PathVariable Long id) {
        boardMemberService.deleteBoardMember(id);
        return ResponseEntity.ok().build();
    }

}
