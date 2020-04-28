package cn.wangdpwin.test.base.poi;

import java.lang.reflect.Field;

/**
 * @Author: wangdongpeng
 * @Date: 2019/2/28 下午2:07
 * @Description
 * @Version 1.0
 */
public class AnnotationUtils {
    /**
     * 是否有指定的annotation存在.
     *
     * @param field
     * @param annotationClass
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static boolean has(Field field, Class annotationClass) {
        return field.getAnnotation(annotationClass) != null;
    }

    /**
     * 是否有指定的annotation存在.
     *
     * @param classOfBean
     * @param annotationClass
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static boolean has(Class<?> classOfBean, Class annotationClass) {
        return classOfBean.getAnnotation(annotationClass) != null;
    }

}
