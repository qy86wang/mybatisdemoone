package com.aaa.mb.dao;

import java.util.List;
import java.util.Map;

public interface EmpDao {
    /**
     * 获取雇员列表
     * @param map
     * @return
     */
    List<Map> getList(Map map);

    /**
     * 获取列表
     * @param map
     * @return
     */
    List<Map> getListByParam(Map map);

    /**
     *获取雇员列表（foreach用法）
     * @param list
     * @return
     */
    List<Map>getListByList(List list);
}
