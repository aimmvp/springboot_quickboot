package me.s0wnd.securityboard.persistence;

import me.s0wnd.securityboard.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {
}
