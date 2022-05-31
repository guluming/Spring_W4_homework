package com.sparta.spring_w4_homework.service;

import com.sparta.spring_w4_homework.model.Board;
import com.sparta.spring_w4_homework.repository.BoardRepository;
import com.sparta.spring_w4_homework.requestdto.BoardRequestDto;
import com.sparta.spring_w4_homework.responsedto.BoardResponseDto;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //게시글 저장
    @Transactional
    public String boardsave(BoardRequestDto params, String userid) {
        if (params.getContentb().equals("")) {
            return "게시물 내용을 입력해주세요";
        }
        Board board = new Board(params.getTitle(), params.getContentb(), userid);
        boardRepository.save(board);
        return "게시글이 저장되었습니다";
    }

    //게시글 전체 조회
    public List<BoardResponseDto> boardfindAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "modifiedAt");
        List<Board> list = boardRepository.findAll(sort);
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    //게시글 상세 조회
    public BoardResponseDto boardfindById(Long id) {
        Board entity = boardRepository.findById(id).orElseThrow(() -> new NullPointerException("존재하지 않는 게시글 입니다."));
        return new BoardResponseDto(entity);
    }

    //게시글 수정
    @Transactional
    public String boardupdate(Long id, BoardRequestDto params, String userid) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new NullPointerException("존재하지 않는 게시글 입니다."));
        if (!board.getUsername().equals(userid)) {
            return "게시글 작성자가 아닙니다.";
        }

        if (params.getContentb().equals("")) {
            return "게시물 내용을 입력해주세요";
        }
        board.update(params.getTitle(), params.getContentb());
        return "게시글이 수정 되었습니다.";
    }

    //게시글 삭제
    @Transactional
    public String boarddelete(Long id, String userid) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new NullPointerException("존재하지 않는 게시글 입니다."));
        if (!board.getUsername().equals(userid)) {
            return "게시글 작성자가 아닙니다.";
        }
        boardRepository.deleteById(id);
        return "게시글이 삭제 되었습니다.";
    }
}
