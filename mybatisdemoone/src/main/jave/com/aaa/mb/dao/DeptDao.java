package com.aaa.mb.dao;
/**
 * className:Dept
 * discriptoin: 部门Dao接口
 * author:WangPJ
 * createTime:2018-11-03 16:09
 */
import com.aaa.mb.entity.Dept;

import java.util.List;

public interface DeptDao {
    /**
     * 获取部门列表
     * @return
     */
    List<Dept> getList();

    /**
     * 部门添加
     * @param dept
     * @return
     */
    int add(Dept dept);

    /**
     * 根据部门编号查询部门信息
     * @param deptNo
     * @return
     */
    Dept getById(int deptNo);

    /**
     * 更新
     * @param dept
     * @return
     */
    int update(Dept dept);

    /**
     * 删除
     * @param deptNo
     * @return
     */
    int delete(int deptNo);

    /**
     * mybatis 高级映射  一对多
     * @return
     */
    List<Dept> oneToMany();
}
