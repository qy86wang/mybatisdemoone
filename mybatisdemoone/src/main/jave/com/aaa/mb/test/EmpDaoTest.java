package com.aaa.mb.test;

import com.aaa.mb.dao.EmpDao;
import com.aaa.mb.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:EmpDaoTest
 * discriptoin:
 * author:WangPJ
 * createTime:2018-11-05 16:50
 */
public class EmpDaoTest {
    @Test
    public void testGetList(){
        SqlSession sqlSession =null;
        try {
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            EmpDao empDao = sqlSession.getMapper(EmpDao.class);
            Map paramMap = new HashMap();
            paramMap.put("job","CLERK");
            paramMap.put("startDate","1981-01-01");
            paramMap.put("endDate","1987-01-01");
            List<Map> list = empDao.getList(paramMap);
            for (Map map : list) {
                System.out.println("名称:"+map.get("ENAME")+"职位:"+map.get("JOB"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getListByParam(){
        SqlSession sqlSession =null;
        try {
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            EmpDao empDao = sqlSession.getMapper(EmpDao.class);
            Map paramMap = new HashMap();
            //paramMap.put("job","CLERK");
            //paramMap.put("startDate","1981-01-01");
            //paramMap.put("endDate","1987-01-01");
            List<Map> list = empDao.getListByParam(paramMap);
            for (Map map : list) {
                System.out.println("名称:"+map.get("ENAME")+"职位:"+map.get("JOB"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void testGetListByList(){
        SqlSession sqlSession =null;
        try {
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            EmpDao empDao = sqlSession.getMapper(EmpDao.class);
           List paramList = new ArrayList();
           paramList.add(7396);
           paramList.add(7900);
           paramList.add(7654);
           paramList.add(7566);
            List<Map> list = empDao.getListByList(paramList);
            for (Map map : list) {
                System.out.println("名称:"+map.get("ENAME")+"职位:"+map.get("JOB"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
