package my.fillYourself.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comment")
@NoArgsConstructor
public class Comment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @ManyToOne // 다대일 관계 설정
    @JoinColumn(name="board_id") // name 속성으로 매핑할 외래키 이름을 지정함
    private Board board;

}
