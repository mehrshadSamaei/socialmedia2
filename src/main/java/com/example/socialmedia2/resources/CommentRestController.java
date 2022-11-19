package com.example.socialmedia2.resources;

import com.example.socialmedia2.dto.CommentDto;
import com.example.socialmedia2.entity.CommentEntity;
import com.example.socialmedia2.mapper.CommentMapper;
import com.example.socialmedia2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentRestController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @PostMapping("/write-comment")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto) {
        CommentEntity commentEntity = commentMapper.convertDtoToT(commentDto);
        commentEntity = commentService.saveOrUpdate(commentEntity);
        return ResponseEntity.ok(
                commentMapper.convertTToDto(commentEntity)
        );
    }
    @PutMapping("/update-comment")
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto){
        CommentEntity commentEntity = commentMapper.convertDtoToT(commentDto);
        commentEntity = commentService.saveOrUpdate(commentEntity);
        return ResponseEntity.ok(
                commentMapper.convertTToDto(commentEntity)
        );
    }
    @GetMapping("/find-comment-by-id")
    public ResponseEntity<CommentDto> findCommentById(@RequestParam Long id){
        CommentEntity commentEntity = commentService.findById(id);
        return ResponseEntity.ok(
                commentMapper.convertTToDto(commentEntity)
        );
    }
    @GetMapping("/find-all-comment")
    public ResponseEntity<List<CommentDto>> findAllComments(){
        List<CommentEntity> commentEntities = commentService.findAll();
        return ResponseEntity.ok(
                commentMapper.convertListEntityToListDto(commentEntities)
        );
    }
//    @DeleteMapping("/delete-comment")
//    public void deleteComment(@RequestBody CommentDto commentDto){
//        CommentEntity commentEntity = commentMapper.convertDtoToT(commentDto);
//        commentService.deleteEntity(commentEntity);
//    }
    @DeleteMapping("/delete-comment-by-id/{id}")
    public void deleteCommentById(@PathVariable Long id){
        commentService.deleteById(id);
    }
}
