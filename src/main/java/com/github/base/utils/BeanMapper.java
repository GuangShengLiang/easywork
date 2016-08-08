package com.github.base.utils;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;

/**
 * @Author lgs
 * @Date 15-12-2 下午4:20
 */
public class BeanMapper {

    private final static MapperFacade mapper;

    private final static MapperFactory factory;
    static {
        factory = new DefaultMapperFactory.Builder().build();
        //注册一个mapper,这段可以同过继承configurableMapper类，配置成spring bean
        /*factory.registerClassMap(factory.classMap(SourceObj.class, DescObj.class)
                //设置正向空值不复制，反向空值不复制
                .mapNulls(false).mapNullsInReverse(false)
                //相同的字段不需要显示声明
                //.field("prop1", "prop1")
                .field("intProp2", "prop2")
                //List, Array, Map类型的复制方式
                .field("listProp3{}", "prop3{}").mapNulls(true)
                .byDefault().toClassMap());*/
        //获取mapper
        mapper = factory.getMapperFacade();
    }

    public static MapperFactory getMapperFactory(){
        return factory;
    }
    public static MapperFacade getMapper(){
        return mapper;
    }
    /**
     * Create and return a new instance of type D mapped with the properties of
     * <code>sourceObject</code>.
     * @param source
     * @param destinationClass
     * @param <S>
     * @param <D>
     * @return
     */
    public static <S, D> D map(S source, Class<D> destinationClass) {
        return mapper.map(source, destinationClass);
    }
    /**
     * Maps the properties of <code>sourceObject</code> onto
     * <code>destinationObject</code>.
     *
     * @param source
     *            the object from which to read the properties
     * @param dest
     *            the object onto which the properties should be mapped
     */
    public static <S, D> void map(S source, D dest) {
        if (source == null){
            return;
        }
        mapper.map(source, dest);
    }

    /**
     * Maps the source Iterable into a new List parameterized by
     * <code>destinationClass</code>.
     *
     * @param source
     *            the Iterable from which to map
     * @param destinationClass
     *            the type of elements to be contained in the returned Set.
     * @return a new List containing elements of type
     *         <code>destinationClass</code> mapped from the elements of
     *         <code>source</code>.
     */
    public static <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
        return mapper.mapAsList(source, destinationClass);
    }


}
