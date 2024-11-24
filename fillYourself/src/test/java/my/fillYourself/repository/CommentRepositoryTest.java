package my.fillYourself.repository;

import my.fillYourself.dto.CommentRequestDto;
import my.fillYourself.dto.CommentResponseDto;
import my.fillYourself.entity.Board;
import my.fillYourself.entity.Comment;
import my.fillYourself.service.CommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CommentRepositoryTest {


    private CommentRepository commentRepository;
    private BoardRepository boardRepository;
    private CommentService commentService;
    public CommentRepositoryTest(CommentRepository c, CommentService service, BoardRepository board){
        this.commentRepository=c;
        this.commentService=service;
        this.boardRepository=board;
    }

    @Test
    @DisplayName("CommentDto로 Comment가 잘 만들어지고 DB에 들어가는지 확인한다.")
    public void createComment(){
        Long boardId=5L;
        Board board = boardRepository.findById(boardId).orElseThrow();
        String content = "content test1 for board id=5";
        CommentRequestDto dto = new CommentRequestDto(content);
        Comment expected = commentService.createComment(boardId,dto);
        Comment comment = new Comment(null,content,board);
        assertEquals(expected,comment);

    }

}