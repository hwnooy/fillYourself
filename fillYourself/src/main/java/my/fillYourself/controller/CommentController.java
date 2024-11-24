package my.fillYourself.controller;

import lombok.RequiredArgsConstructor;
import my.fillYourself.converter.CommentConverter;
import my.fillYourself.dto.CommentRequestDto;
import my.fillYourself.dto.CommentResponseDto;
import my.fillYourself.entity.Comment;
import my.fillYourself.repository.CommentRepository;
import my.fillYourself.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("comment")
public class CommentController {
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @PostMapping("/new")
    public ResponseEntity<CommentResponseDto> createComment(@PathVariable Long boardId, @RequestBody CommentRequestDto dto){
        try{
            Comment comment = commentService.createComment(boardId, dto);
            CommentResponseDto result = CommentConverter.commentToCommentResponseDto(comment);
            return ResponseEntity.ok(result);
        } catch (Exception e){
            return null;
        }
    }
}
