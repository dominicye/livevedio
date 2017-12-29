package com.ways.live.controller;

import com.shentop.ext.dto.PagingResult;
import com.ways.live.dto.TvModel;
import com.ways.live.model.Vedio;
import com.ways.live.service.VedioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vedio")
@Api("视频")
public class VedioRestController {

    @Autowired
    private VedioService vedioService;

    /**
     * Get video by sort type and page number for example "精选 C, VIP会员 VP, 热点 H , 综艺 V "
     * @param sortType
     * @return
     */
    @RequestMapping(value = "/getVedios/{sortType}/{pageNum}/{pageSize}", method = RequestMethod.GET)
    @ApiOperation(value="分类获取视频", notes="")
    public PagingResult<Vedio> getVediosBySortType(@PathVariable("sortType") String sortType, @PathVariable ("pageNum") int pageNum, @PathVariable ("pageSize") int pageSize ,HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
        return vedioService.getVediosBySortType(sortType, pageNum, pageSize);
    }

    /**
     * get tv serial by name and page number
     * @param name
     * @return
     */
    @RequestMapping(value = "/getTvSerial/{name}", method = RequestMethod.GET)
    @ApiOperation(value="根据电视剧名字获取电视剧", notes="")
    public List<Vedio> getTvSerialByName(@PathVariable("name") String name, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
        return vedioService.getTvSerialByName(name);
    }

    /**
     * Get videos by video name search
     * @param name
     * @return
     */
    @ApiOperation(value="根据名字视频")
    @RequestMapping(value = "/getVideosByName", method = RequestMethod.GET)
    public List<Vedio> getVideosByName(@RequestParam String name, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
        return vedioService.getVideosByName(name);
    }

    /**
     * Get top video by sort name
     * @param sortName
     * @return
     */
    @RequestMapping(value = "/getTopVideo" , method = RequestMethod.GET)
    @ApiOperation(value="根据分类获取上方视频")
    public List<Vedio> getTopVideoBySortType(@RequestParam String sortName, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
        return vedioService.getTopVideoBySortType(sortName);
    }

    @RequestMapping(value = "/getVideoById" , method = RequestMethod.GET)
    @ApiOperation(value="根据id获取视频")
    public Vedio getVedioById(@RequestParam int id, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");

        return vedioService.getVedioById(id);
    }

    @RequestMapping(value = "/getAllTvs", method = RequestMethod.GET)
    @ApiOperation(value="获取所有电视剧")
    public List<Vedio> getAllTvs( HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
        return vedioService.getAllTVs();
    }

    @RequestMapping(value = "/getTvsById", method = RequestMethod.GET)
    @ApiOperation(value="根据电视剧id获取所有集数")
    public List getSpecificTvById(@RequestParam int id, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
        List l = vedioService.getSpecificTvById(id);
        List<TvModel> datas = new ArrayList<TvModel>();
        for(Object o : l)
        {
            TvModel tv = new TvModel();
            Object [] data = (Object[])o;
            tv.setId((Integer) data[0]);
            tv.setVedioUrl("");
            tv.setVedioType((String)data[2]);
            tv.setCoverUrl((String)data[3]);
            tv.setCoverName((String)data[4]);
            tv.setCoverTitle((String)data[5]);
            tv.setCoverDescription((String)data[6]);
            tv.setCoverLocation((String)data[7]);
            tv.setClickTime((Integer) data[8]);
            tv.setVedioSortType("");
            tv.setTvid((Integer) data[10]);
            tv.setVedioId((Integer) data[11]);
            tv.setTvUrl((String)data[12]);
            tv.setTvNum((Integer)data[13]);
            datas.add(tv);
        }
        return datas;
    }

}
