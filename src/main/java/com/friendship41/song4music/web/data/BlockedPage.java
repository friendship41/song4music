package com.friendship41.song4music.web.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;

@Data
@NoArgsConstructor
@ToString
public class BlockedPage
{
    private Page page;
    private int prevNum;
    private int nextNum;
    private int startBlock;
    private int endBlock;

    public BlockedPage(Page page)
    {
        this.page = page;
        int nowPage = page.getNumber()+1;
        int size = page.getSize();
        int totalPage = page.getTotalPages();
        startBlock = nowPage-nowPage%size+1;
        endBlock = startBlock + size-1;
        if(endBlock > totalPage){
            endBlock = totalPage;
        }
        prevNum = -1;
        nextNum = -1;
        if(nowPage >= size){
            prevNum = startBlock-3;
        }
        if (totalPage > endBlock){
            nextNum = endBlock-1;
        }
    }
}
