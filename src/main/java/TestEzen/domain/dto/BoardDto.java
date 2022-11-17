package TestEzen.domain.dto;

import TestEzen.domain.entity.BoardEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter @Builder
public class BoardDto {
    private int bno; //게시물번호
    private String btitle; //게시물제목
    private String bcontent; //게시물내용

    public BoardEntity toEntity() {
        return BoardEntity.builder()
               .bno(this.bno)
               .btitle(this.btitle)
               .bcontent(this.bcontent)
               .build();
    }

}
