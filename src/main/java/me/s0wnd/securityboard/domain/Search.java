package me.s0wnd.securityboard.domain;

import lombok.Data;

@Data
public class Search {
    private String searchCondition;
    private String searchKeyword;
}
