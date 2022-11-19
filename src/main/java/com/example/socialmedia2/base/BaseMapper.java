package com.example.socialmedia2.base;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T extends BaseEntity<ID>
        , D extends BaseDto<ID> , ID extends Serializable> {

    T convertDtoToT(D d);

    D convertTToDto(T t);

    List<T> convertListDtoToListEntity(List<D> dList);

    List<D> convertListEntityToListDto(List<T> tList);

}
