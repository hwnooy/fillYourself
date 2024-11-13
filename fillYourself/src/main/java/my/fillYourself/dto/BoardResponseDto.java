package my.fillYourself.dto;

import lombok.Builder;

@Builder
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    // 나중에
    // private Long userId;
}
