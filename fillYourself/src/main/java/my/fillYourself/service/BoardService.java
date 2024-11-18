package my.fillYourself.service;

import lombok.RequiredArgsConstructor;
import my.fillYourself.dto.BoardRequestDto;
import my.fillYourself.entity.Board;
import my.fillYourself.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board makeBoard(BoardRequestDto dto){

        Board board = Board.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();

        boardRepository.save(board);
        return board;
    }


    public Board updateBoard(Long id, BoardRequestDto dto) {
        Board board = boardRepository.findById(id).orElseThrow();
        board.updateTitle(dto.getTitle());
        board.updateContent(dto.getContent());
        boardRepository.save(board);
        return board;
    }


    public Board getBoard(Long id){
        return boardRepository.findById(id).orElseThrow();
    }

    public List<Board> getBoards(){
        return boardRepository.findAll();
    }

    public void deleteBoard(Long id){
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Does Not Exist"));
        boardRepository.delete(board);

    }
}
