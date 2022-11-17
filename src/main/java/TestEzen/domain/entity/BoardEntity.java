package TestEzen.domain.entity;

import TestEzen.domain.dto.BoardDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "board")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno; //게시물번호
    private String btitle; //게시물제목
    private String bcontent; //게시물내용

    public BoardDto toDto(){
        return BoardDto
                .builder() // 빌더 메소드 시작
                .bno( this.bno )
                .btitle(this.btitle)
                .bcontent( this.bcontent )
                .build(); // 빌드 메소드 끝
    }
}
