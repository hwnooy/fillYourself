package my.fillYourself.controller;

import lombok.RequiredArgsConstructor;
import my.fillYourself.converter.BoardConverter;
import my.fillYourself.dto.BoardRequestDto;
import my.fillYourself.dto.BoardResponseDto;
import my.fillYourself.entity.Board;
import my.fillYourself.service.BoardService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/{id}/update")
    public ResponseEntity<BoardResponseDto> updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto dto){
        try{
            Board board = boardService.updateBoard(id, dto);
            BoardResponseDto response = BoardConverter.returnBoardResponseDtoAtController(board);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.badRequest()
                    .body(BoardResponseDto.builder()
                            .id(id)
                            .title(e.getMessage())
                            .content(dto.getContent())
                            .build());
        }

    }
}
