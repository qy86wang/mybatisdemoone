package com.aaa.mb.dao;

import com.aaa.mb.entity.News;

import java.util.List;
import java.util.Map;

public interface NewsDao {
    /**
     * 获取列表
     * @return
     */
    List<Map> getListMap(Map map);

    /**
     * 添加
     * @param map
     * @return
     */
    int add(Map map);

    /**
     * 获取Id
     * @param newsid
     * @return
     */
    List<Map> getById(int newsid);

    /**
     * 修改
     * @param map
     * @return
     */
    int update(Map map);

    /**
     *
     * @return
     */
    int delete(int newsid);

    /**
     * 多对一
     * @return
     */
    List<News> manyToOne();
}
