package com.nobug.experiment.tool.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author liyupeng01
 * @version 1.0.0
 * @Description mapstruct转换接口
 * @createTime 2021年 05月 14:12:00
 */
@Mapper
public interface MapStructTargetConverter {
    MapStructTargetConverter INSTANCE = Mappers.getMapper(MapStructTargetConverter.class);

    MapStructTarget toMapStructTarget(MapStructSource mapStructSource);
}
