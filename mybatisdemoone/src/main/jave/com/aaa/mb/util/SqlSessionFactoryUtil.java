package com.aaa.mb.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * className:SqlSessionFactoryUtil
 * discriptoin:
 * author:WangPJ
 * createTime:2018-11-03 16:37
 */
public class SqlSessionFactoryUtil {
    //私有空构造，保证其他地方不能实例化对象
    private  SqlSessionFactoryUtil(){};

    //私有的静态的属性，保证只有一个 并且其他地方不能调用
    private  static SqlSessionFactory sqlSessionFactory;

    //使用静态块
    static {
        //使用mybatis提供的Resourcrs类读取配置文件
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            //创建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //提供一个对外可以调用的方法 返回SqlSession
    public  static SqlSession createSqlSession(){
        return  sqlSessionFactory.openSession();
    }
}
