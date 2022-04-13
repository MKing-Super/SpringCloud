package pers.mk.sys.repository.annotion;

import org.springframework.context.annotation.Import;
import pers.mk.sys.repository.config.MybatisConfig;

import java.lang.annotation.*;

/**
 * @author wwq
 * @Description TODO
 * @Date 2022/4/11
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(MybatisConfig.class)
public @interface EnableMybatisConfig {
}
