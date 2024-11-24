package my.fillYourself.service;

import lombok.RequiredArgsConstructor;
import my.fillYourself.dto.CommentRequestDto;
import my.fillYourself.entity.Board;
import my.fillYourself.entity.BoardComment;
import my.fillYourself.entity.Comment;
import my.fillYourself.repository.BoardRepository;
import my.fillYourself.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public Comment createComment(Long boardId,CommentRequestDto dto){
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("No Board with Id "+boardId));
        Comment comment = Comment.builder()
                .content(dto.getContent())
                .board(board)
                .build();
        commentRepository.save(comment);
        return comment;
    }
}
