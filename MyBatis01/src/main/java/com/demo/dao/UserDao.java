package com.demo.dao;

import com.demo.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDao {
    private SqlSession sqlSession;

    /**
     * 构造方法
     */
    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /**
     * 根据 id 查询用户信息
     */
    public User selectUserById(Integer id) {
        return sqlSession.selectOne("abc.selectUserById", id);
    }
    /**
     * 查询所有用户数据
     */
    public List<User> selectAll(){
        return sqlSession.selectList("abc.selectAll");
    }
    /**
     * 添加用户
     */
    public Integer addUser(User user){
        return sqlSession.insert("abc.addUser",user);
    }
    /**
     * 修改用户
     */
    public Integer updateUser(User user){
        return sqlSession.update("abc.updateUser",user);
    }
    /**
     * 删除用户
     */
    public Integer deleteUser(Integer id){
        return sqlSession.delete("abc.deleteUserById",id);
    }
}
