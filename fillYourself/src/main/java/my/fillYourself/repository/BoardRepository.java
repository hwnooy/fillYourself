package my.fillYourself.repository;

import my.fillYourself.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {


}
