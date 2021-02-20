package me.s0wnd.securityboard.service;

import com.querydsl.core.BooleanBuilder;
import me.s0wnd.securityboard.domain.Board;
import me.s0wnd.securityboard.domain.QBoard;
import me.s0wnd.securityboard.domain.Search;
import me.s0wnd.securityboard.persistence.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;

    public void insertBoard(Board board) {
        boardRepository.save(board);
    }

    public void updateBoard(Board board) {
        Board findBoard = boardRepository.findById(board.getSeq()).get();

        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());
        boardRepository.save(findBoard);
    }

    public void deleteBoard(Board board) {
        boardRepository.deleteById(board.getSeq());
    }

    public Board getBoard(Board board) {
        return boardRepository.findById(board.getSeq()).get();
    }

    public Page<Board> getBoardList(Search search) {
        BooleanBuilder builder = new BooleanBuilder();

        QBoard qBoard = QBoard.board;

        if(search.getSearchCondition().equals("TITLE")) {
            builder.and(qBoard.title.like("%" + search.getSearchKeyword() + "%"));
        } else if (search.getSearchCondition().equals("CONTENT")){
            builder.and(qBoard.content.like("%" + search.getSearchKeyword() + "%"));
        }
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
        return boardRepository.getBoardList(pageable);
    }
}
