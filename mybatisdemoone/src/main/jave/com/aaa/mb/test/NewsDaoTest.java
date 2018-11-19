package com.aaa.mb.test;

import com.aaa.mb.dao.NewsDao;
import com.aaa.mb.entity.News;
import com.aaa.mb.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:NewsDaoTest
 * discriptoin:
 * author:WangPJ
 * createTime:2018-11-06 08:28
 */
public class NewsDaoTest {
    /**
     * 查询
     */
    @Test
    public void getListMap(){
        SqlSession sqlSession =null;
        try {
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
            Map param = new HashMap();
            param.put("typeid","1");
            List<Map> list = newsDao.getListMap(param);
            for (Map map : list) {
                System.out.println("标题:"+map.get("TITLE")+"内容:"+map.get("CONTENT")+"类型："+map.get("TYPEID")+"日期"+map.get("ADDTIME"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 添加
     */
    @Test
    public void add(){
        SqlSession sqlSession =null;
        try {
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            NewsDao newsDao = sqlSession.getMapper(NewsDao.class);
            Map map = new HashMap();
            map.put("title","标题");
            map.put("content","内容");
            map.put("typeid","1");
            int h = newsDao.add(map);

            sqlSession.commit();
            if(h>0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 修改
     */
    @Test
    public  void update(){
        SqlSession sqlSession =null;
        try {
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            NewsDao newsDao = sqlSession.getMapper(NewsDao.class);

            List<Map> newId = newsDao.getById(15);
            Map map = newId.get(0);
            map.put("TITLE","标题1");
            map.put("CONTENT","内容1");
            map.put("TYPEID",1);
            //map.put("newsid","15");
            System.out.println(map);
            int h = newsDao.update(map);

            sqlSession.commit();
            if(h>0){
                System.out.println("更新成功");
            }else {
                System.out.println("更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void delete(){
        SqlSession sqlSession =null;
        try {
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            NewsDao newsDao = sqlSession.getMapper(NewsDao.class);

            int result = newsDao.delete(8);


            sqlSession.commit();
            if(result>0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public  void  testManyToOne(){
        SqlSession sqlSession =null;
        try {
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            NewsDao newsDao = sqlSession.getMapper(NewsDao.class);

            List<News> news = newsDao.manyToOne();

            if(news!=null && news.size()>0){
                for (News news1 : news) {
                    System.out.println("新闻标题："+news1.getTitle()+",内容:"+news1.getContent()+",分类名称："+news1.getNewsType().getTypeName());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


}
