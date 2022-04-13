package pers.mk.sys.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.mk.sys.repository.model.entity.Vehicle;

/**
 * <p>
 * 车辆信息表 Mapper 接口
 * </p>
 *
 * @author wwq
 * @since 2022-04-11
 */
@Mapper
public interface VehicleMapper extends BaseMapper<Vehicle> {

}

