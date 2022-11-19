package com.example.socialmedia2.resources;

import com.example.socialmedia2.dto.PostDto;
import com.example.socialmedia2.entity.PostEntity;
import com.example.socialmedia2.mapper.PostMapper;
import com.example.socialmedia2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostResController {
    private final PostService postService;
    private final PostMapper postMapper;

    @PutMapping("/update-post")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto) {
        PostEntity postEntity = postMapper.convertDtoToT(postDto);
        return ResponseEntity.ok(
                postMapper.convertTToDto(
                        postService.saveOrUpdate(postEntity)
                )
        );
    }

    @GetMapping("/find-post-by-id")
    public ResponseEntity<PostDto> findPostById(@RequestParam Long id) {
        PostEntity postEntity = postService.findById(id);
        return ResponseEntity.ok(
                postMapper.convertTToDto(postEntity)
        );
    }

    @GetMapping("/find-all-post")
    public ResponseEntity<List<PostDto>> findAll() {
        List<PostEntity> postEntities = postService.findAll();
        return ResponseEntity.ok(
                postMapper.convertListEntityToListDto(postEntities)
        );
    }
//    @DeleteMapping("/delete-post")
//    public void deletePost(@RequestBody PostDto postDto){
//        PostEntity postEntity = postMapper.convertDtoToT(postDto);
//        postService.deleteEntity(postEntity);
//    }
    @DeleteMapping("/delete-post-by-id/{id}")
    public void deletePostById(@PathVariable Long id){
        postService.deleteById(id);
    }
}
