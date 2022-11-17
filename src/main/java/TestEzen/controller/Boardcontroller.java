package TestEzen.controller;

import TestEzen.domain.dto.BoardDto;
import TestEzen.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@ResponseBody
public class Boardcontroller {
    @Autowired
    private BoardService boardService; //리포지토리 객체

    //html반환
    @GetMapping("/")
    public Resource index() {
        return new ClassPathResource("templates/index.html");
    }

    //서비스기능
    @PostMapping("/getwrite")
    public boolean getwrite(@RequestBody BoardDto boardDto){
        boolean result = boardService.bwrite(boardDto);
        return true;
    }

    @GetMapping("/setlist")
    public List<BoardDto> setlist() {
        List<BoardDto> list = boardService.setlist();
        return list;
    }
}
