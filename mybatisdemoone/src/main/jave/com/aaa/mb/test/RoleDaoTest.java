package com.aaa.mb.test;

import com.aaa.mb.dao.RoleDao;
import com.aaa.mb.entity.Power;
import com.aaa.mb.entity.Role;
import com.aaa.mb.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * className:RoleDaoTest
 * discriptoin:
 * author:WangPJ
 * createTime:2018-11-06 20:33
 */
public class RoleDaoTest {

    @Test
    public void testManyToMany(){
        SqlSession sqlSession =null;
        try {
            sqlSession = SqlSessionFactoryUtil.createSqlSession();
            RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
            List<Role> roles = roleDao.manyToMany();
            if(roles!=null&&roles.size()>0){

                for (Role role : roles) {
                    System.out.println("角色："+role.getName());
                    List<Power> powerList = role.getPowerList();
                    if(powerList!=null && powerList.size()>0){
                        System.out.println("角色看到的权限有："+powerList.size()+"个，分别为：");
                        for (Power power : powerList) {
                            System.out.println("权限名称:"+power.getName()+",url:"+power.getUrl()+"父ID:"+power.getPid());
                        }
                    }else {
                        System.out.println("该角色看不到任何权限");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }
}
