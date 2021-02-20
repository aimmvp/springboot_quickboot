package me.s0wnd.securityboard.persistence;

import me.s0wnd.securityboard.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board> {

    @Query("SELECT b FROM Board b")
    Page<Board> getBoardList(Pageable pageable);
}
