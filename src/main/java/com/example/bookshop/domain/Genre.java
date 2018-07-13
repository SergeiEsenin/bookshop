package com.example.bookshop.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Genre implements GrantedAuthority {

    ScienceFiction,
    Satire,
    Drama,
    Action,
    Adventure,
    Romance,
    Mystery,
    Horror,
    Religion,
    Science,
    History,
    Poetry,
    Comics,
    Art,
    Biographies,
    Fantasy;
    @Override
    public String getAuthority() {
        return name();
    }
}


