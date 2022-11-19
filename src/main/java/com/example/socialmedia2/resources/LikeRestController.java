package com.example.socialmedia2.resources;

import com.example.socialmedia2.dto.LikeDto;
import com.example.socialmedia2.entity.LikeEntity;
import com.example.socialmedia2.mapper.LikeMapper;
import com.example.socialmedia2.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeRestController {
    private final LikeService likeService;
    private final LikeMapper likeMapper;
    @PostMapping("/add-like")
    public ResponseEntity<LikeDto> addLike(@RequestBody LikeDto likeDto){
        LikeEntity likeEntity = likeMapper.convertDtoToT(likeDto);
        return ResponseEntity.ok(
                likeMapper.convertTToDto(
                        likeService.saveOrUpdate(likeEntity)
                )
        );
    }
//    @DeleteMapping("/delete-like")
//    public void deleteLike(@RequestBody LikeDto likeDto){
//        LikeEntity likeEntity = likeMapper.convertDtoToT(likeDto);
//        likeService.deleteEntity(likeEntity);
//    }
    @DeleteMapping("/delete-like-by-id/{id}")
    public void deleteLikeById(@PathVariable Long id){
        likeService.deleteById(id);
    }
}
