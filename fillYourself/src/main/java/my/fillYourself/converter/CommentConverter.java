package my.fillYourself.converter;

import my.fillYourself.dto.CommentResponseDto;
import my.fillYourself.entity.Comment;

public class CommentConverter {

    public static CommentResponseDto commentToCommentResponseDto(Comment comment){
        return CommentResponseDto.builder()
                .boardId(comment.getBoard().getId())
                .commentId(comment.getId())
                .content(comment.getContent())
                .build();
    }
}
