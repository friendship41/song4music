package com.friendship41.song4music.web.service;

import org.springframework.data.domain.Page;

public interface PageBlockService
{
    public int getStartBlockNum(Page page);
    public int getEndBlockNum(Page page);
}
