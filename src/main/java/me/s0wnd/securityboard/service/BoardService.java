package me.s0wnd.securityboard.service;

import me.s0wnd.securityboard.domain.Board;
import me.s0wnd.securityboard.domain.Search;
import org.springframework.data.domain.Page;

public interface BoardService {
    void insertBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(Board board);
    Board getBoard(Board board);

    Page<Board> getBoardList(Search search);
}
