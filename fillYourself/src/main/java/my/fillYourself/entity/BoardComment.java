package my.fillYourself.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class BoardComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_comment_ID")
    private Long id;

    @Column
    private String content;

    @Column
    private String writer;
}
