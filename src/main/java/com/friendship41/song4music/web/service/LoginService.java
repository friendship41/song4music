package com.friendship41.song4music.web.service;

import com.friendship41.song4music.repository.entity.Member;

public interface LoginService {
    public Member login();
    public Member login(String code);
}
