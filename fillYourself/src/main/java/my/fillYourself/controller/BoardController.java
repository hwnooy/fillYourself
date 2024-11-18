package my.fillYourself.controller;

import lombok.RequiredArgsConstructor;
import my.fillYourself.converter.BoardConverter;
import my.fillYourself.dto.BoardRequestDto;
import my.fillYourself.dto.BoardResponseDto;
import my.fillYourself.entity.Board;
import my.fillYourself.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/new")
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody BoardRequestDto dto){
        Board board = boardService.makeBoard(dto);
        BoardResponseDto response = BoardConverter.returnBoardResponseDtoAtController(board);
        return ResponseEntity.ok(response);

    }
}
