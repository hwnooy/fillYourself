package my.fillYourself.converter;

import my.fillYourself.dto.BoardResponseDto;
import my.fillYourself.entity.Board;

import java.util.ArrayList;
import java.util.List;

public class BoardConverter {

    public static BoardResponseDto returnBoardResponseDto(Board board){
        return BoardResponseDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }

    public static List<BoardResponseDto> returnBoardResponseDtoList(List<Board> boards){
        List<BoardResponseDto> dtos = new ArrayList<>();
        for (Board board : boards) {
            dtos.add(returnBoardResponseDto(board));
        }
        return dtos;
    }
}
