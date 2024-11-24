package my.fillYourself.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name="board")
public class Board extends BaseEntity {

    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @OneToMany
    private List<Comment> comments;

    public void updateTitle(String title){
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("title cannot be null");
        } else {
            this.title=title;
        }
    }
    public void updateContent(String content){
        if (content != null) {
            this.content=content;
        }
    }

}
