package my.fillYourself.service;

import my.fillYourself.dto.CommentRequestDto;
import my.fillYourself.entity.Board;
import my.fillYourself.entity.Comment;
import my.fillYourself.repository.BoardRepository;
import my.fillYourself.repository.CommentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentServiceTest {

    @Autowired
    private CommentService commentService;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Test
    @DisplayName("comment Create 작동확인")
    public void createComment(){

        Long boardId = 5L;
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("board 찾기 실패"));
        String content = "comment content 내용 test for board id=5";
        CommentRequestDto dto = new CommentRequestDto(content);

        // When
        Comment expected = commentService.createComment(boardId, dto);

        // Then
        Comment actual = commentRepository.findById(expected.getId())
                .orElseThrow(() -> new IllegalArgumentException("comment 찾기 실패"));
        assertEquals(expected.getContent(), actual.getContent());
        assertEquals(expected.getBoard().getId(), actual.getBoard().getId());
    }




}