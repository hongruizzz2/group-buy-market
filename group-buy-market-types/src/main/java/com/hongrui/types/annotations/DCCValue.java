package com.hongrui.types.annotations;

import java.lang.annotation.*;

/**
 * @author hongrui
 * @description 注解 动态配置中心 - 标记
 * @date 2025-03-17 16:49
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface DCCValue {

    String value() default "";

}
