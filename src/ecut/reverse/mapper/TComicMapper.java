package ecut.reverse.mapper;

import ecut.reverse.po.TComic;
import ecut.reverse.po.TComicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TComicMapper {
    long countByExample(TComicExample example);

    int deleteByExample(TComicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TComic record);

    int insertSelective(TComic record);

    List<TComic> selectByExample(TComicExample example);

    TComic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TComic record, @Param("example") TComicExample example);

    int updateByExample(@Param("record") TComic record, @Param("example") TComicExample example);

    int updateByPrimaryKeySelective(TComic record);

    int updateByPrimaryKey(TComic record);
}