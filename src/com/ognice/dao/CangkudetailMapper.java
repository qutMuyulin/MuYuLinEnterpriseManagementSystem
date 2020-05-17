package com.ognice.dao;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Cangkudetail;

import java.util.List;
/**
*
* 库存 dao类
*
**/
public interface CangkudetailMapper {
    int delete(Integer id);

    int insert(Cangkudetail record);

    Cangkudetail selectCangkudetailById(Integer id);

    int update(Cangkudetail record);

    List<Cangkudetail> page(PageSearchParam param);


    Cangkudetail getCangkuMater(Integer cangkuid,Integer materid);

    Cangkudetail getCangkuPro(Integer cangkuid,Integer proid);
}