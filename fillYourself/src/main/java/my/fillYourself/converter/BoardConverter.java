package my.fillYourself.converter;

import my.fillYourself.dto.BoardResponseDto;
import my.fillYourself.entity.Board;

public class BoardConverter {

    public static BoardResponseDto returnBoardResponseDtoAtController(Board board){
        return BoardResponseDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }
}
