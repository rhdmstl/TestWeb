package TestEzen.service;

import TestEzen.domain.dto.BoardDto;
import TestEzen.domain.entity.BoardEntity;
import TestEzen.domain.entity.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired //스프링 컨태이너 메모리위임
    private HttpServletRequest request; //요청객체(매핑을 안쓸때 쓰면됌)
    @Transactional
    public boolean bwrite(BoardDto boardDto){
        // 1. DAO 처리 [ insert ]
        BoardEntity entity = boardRepository.save( boardDto.toEntity() );
        // memberRepository.save( 엔티티 객체 ) : 해당 엔티티 객체가 insert 생성된 엔티티객체 반환
        // 2. 결과 반환 [ 생성된 엔티티의 pk값 반환 ]
        return true;
    }
    @Transactional
    public List<BoardDto> setlist(){
        // 1. JPA 이용한 모든 엔티티 호출
        List<BoardEntity> list = boardRepository.findAll();
        List<BoardDto> dtoList = new ArrayList<>();
        for( BoardEntity entity : list ){
            dtoList.add( entity.toDto() ); // 형변환
        }
        return dtoList;
    }
}
