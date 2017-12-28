package com.ways.live.controller;

import com.shentop.ext.dto.PagingResult;
import com.ways.live.model.Vedio;
import com.ways.live.service.VedioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
    @RequestMapping(value = "/getTvSerial/{name}/{pageNum}/{pageSize}", method = RequestMethod.GET)
    @ApiOperation(value="根据电视剧名字获取电视剧", notes="")
    public PagingResult<Vedio> getTvSerialByName(@PathVariable("name") String name, @PathVariable ("pageNum") int pageNum, @PathVariable ("pageSize") int pageSize, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
        return vedioService.getTvSerialByNameAndPageNum(name, pageNum, pageSize);
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

}
