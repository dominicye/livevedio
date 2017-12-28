package com.ways.live.service;

import com.shentop.ext.dto.PagingResult;
import com.shentop.ext.dto.SearchPagingParams;
import com.ways.live.data.VedioRepository;
import com.ways.live.model.Vedio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VedioService {

    @Autowired
    private VedioRepository vedioRepository;
    /**
     * Get video by sort type and page number for example "精选, VIP会员, 热点, 综艺 "
     * @param sortType
     * @return
     */
    public PagingResult<Vedio> getVediosBySortType(String sortType, int pageNum, int pageSize)
    {
        SearchPagingParams params = buildPagePara(pageNum, pageSize);

        PagingResult<Vedio> result = new PagingResult<Vedio>();
        result.setList(vedioRepository.getPagingList(params.getOffset(),params.getPageSize(),sortType));
        result.setTotal(vedioRepository.getCount(sortType));

        return  result;
    }

    public PagingResult<Vedio> getTvSerialByNameAndPageNum(String name, int pageNum, int pageSize)
    {
        SearchPagingParams params = buildPagePara(pageNum, pageSize);
        PagingResult<Vedio> result = new PagingResult<Vedio>();

        result.setList(vedioRepository.getTvSerialByName(name,params.getOffset(),params.getPageSize()));
        result.setTotal(vedioRepository.getTVSerialCount(name));

        return  result;
    }

    private SearchPagingParams buildPagePara(int pageNum, int pageSize)
    {
        SearchPagingParams params = new SearchPagingParams();
        params.setPage(pageNum);
        params.setPageSize(pageSize);

        return params;
    }

    /**
     * Get videos by video name search
     * @param name
     * @return
     */
    public List<Vedio> getVideosByName(String name)
    {
        return (List<Vedio>) vedioRepository.getVediosByName(name);
    }

    /**
     * Get top video by sort type
     * @param sortType
     * @return
     */
    public List<Vedio> getTopVideoBySortType(String sortType)
    {
        return (List<Vedio>) vedioRepository.getTopVideoBySortType(sortType);
    }


    public Vedio getVedioById(int id)
    {
        return vedioRepository.findOne(id);
    }


    /**
     * 根据uri获取video
     * @param uri
     * @return
     */
    public Vedio getVedioByVedioUrl(String uri) {
        return vedioRepository.getVedioByVedioUrl(uri);
    }

    public void UpdateVedio(Vedio vedio){
        vedioRepository.save(vedio);
    }

}
