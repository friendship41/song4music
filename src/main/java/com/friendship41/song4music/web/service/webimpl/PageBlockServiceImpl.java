package com.friendship41.song4music.web.service.webimpl;

import com.friendship41.song4music.web.service.PageBlockService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service("PageBlockService")
public class PageBlockServiceImpl implements PageBlockService
{
    @Override
    public int getStartBlockNum(Page page)
    {
        int start = (page.getNumber()+1)-(page.getNumber()+1)%page.getSize()-1;
        if(start == -1){
            return 0;
        }
        else {
            return start;
        }
    }

    @Override
    public int getEndBlockNum(Page page)
    {
        int end = (page.getNumber()+1)/page.getSize()*page.getSize()+page.getSize();
        if(end > page.getTotalPages())
        {
            return page.getTotalPages()-1;
        }
        else {
            return end-1;
        }
    }
}
