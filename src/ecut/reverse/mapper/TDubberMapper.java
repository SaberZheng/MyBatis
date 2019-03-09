package ecut.reverse.mapper;

import ecut.reverse.po.TDubber;
import ecut.reverse.po.TDubberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDubberMapper {
    long countByExample(TDubberExample example);

    int deleteByExample(TDubberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDubber record);

    int insertSelective(TDubber record);

    List<TDubber> selectByExample(TDubberExample example);

    TDubber selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDubber record, @Param("example") TDubberExample example);

    int updateByExample(@Param("record") TDubber record, @Param("example") TDubberExample example);

    int updateByPrimaryKeySelective(TDubber record);

    int updateByPrimaryKey(TDubber record);
}