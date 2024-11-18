package my.fillYourself.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    // 나중에
    // private Long userId;
}
