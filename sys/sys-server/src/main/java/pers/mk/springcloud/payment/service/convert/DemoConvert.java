package pers.mk.springcloud.payment.service.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DemoConvert {

    /**
     * 为了在某Filter类中使用，否则不需要此单例
     */
    DemoConvert INSTANCE = Mappers.getMapper(DemoConvert.class);

    /**
     * @return
     */
    String convertToVehicle(String demoReqDTO);

}
