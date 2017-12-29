package com.ways.live.data;

import com.ways.live.model.Vedio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VedioRepository extends CrudRepository<Vedio, Integer> {

    @Query(value = "select * from vedio where vedio_sort_type=:sortType and cover_location='T'", nativeQuery = true)
    List<Vedio> getTopVideoBySortType(@Param("sortType") String sortType);

    @Query(value = "select * from vedio where cover_name like CONCAT('%',:name,'%') and cover_location='C'and and vedio_type='M' order by click_time desc", nativeQuery = true)
    List<Vedio> getVediosByName(@Param("name") String name);

    @Query(value = "select * from vedio where cover_name like CONCAT('%',?1,'%') and cover_location='C' and vedio_type='T' ", nativeQuery = true)
    List<Vedio> getTvSerialByName(String name);


    @Query(value = "select * from vedio where vedio_sort_type=?3 and cover_location='C' order BY click_time DESC limit ?1 , ?2 ", nativeQuery = true)
    List<Vedio> getPagingList(Integer offset, Integer pageSize, String type);

    @Query(value = "select COUNT(id) from vedio where vedio_sort_type=?1", nativeQuery = true)
    long getCount(String type);

    @Query(value = "select * from vedio where vedio_url=?1", nativeQuery = true)
    Vedio getVedioByVedioUrl(String uri);

    @Query(value = "select * from vedio where vedio_type='T'", nativeQuery = true)
    List<Vedio> getAllTvs();

    @Query(value = "select a.*, b.id as tvid, b.vedio_id,b.tv_url,b.tv_num from vedio a, tv b where a.id=b.vedio_id and a.id=:id", nativeQuery = true)
    List getSpecificTvById(@Param("id")  int id);
}
