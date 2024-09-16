package com.demo.mapper;

import com.demo.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 在 MyBatis 中，当你在 Mapper 接口的方法中传递多个参数时，
 * 如果你不使用任何机制来明确指定这些参数的名称或顺序，
 * 那么在 XML 映射文件中引用这些参数时就可能会遇到错误，参数对应不上。
 * 解决方法：
 *  1. 使用参数索引：MyBatis 默认使用 arg0、arg1、arg2、...... 或者 param1、param2、param3、...... 来引用参数。
 *  2. 使用 @Param 注解：明确指定每个参数的名称，使得在 XML 映射文件中引用参数时更加清晰和准确。
 *  3. 使用 Map 集合：将多个参数封装到一个 Map 集合中。
 */
public interface UserMapper {
    /**
     * 1. mybatis 接口中的方法，如果接收多个参数，默认情况下，sql 语句中需要使用 mybatis 的默认的变量去命名
     *      Mapper 接口中的方法 ：User getUserByIdAndName(int id, String name);
     *      SQL语句使用 arg0、arg1、arg2、......
     * 	    select * from user where id = #{arg0} and name=#{arg1}
     * 	    SQL语句使用  param1、param2、param3、......
     *      select * from user where id = #{param1} and name=#{param2}
     */

    /**
     *  2. 使用 @Param 注解来明确指定参数的名称
     *  条件查询用户信息
     */
    public List<User> selectUser(@Param(value = "name") String name, @Param(value = "age") Integer age, @Param(value = "sex") Integer sex);

    /**
     * 3. 参数传入一个 Map 集合，key 值与 SQL 中的占位符对应匹配
     */
    public List<User> selectUser2(Map<String, Object> map);

    /**
     * 根据 id 查询用户信息
     */
    public User selectUserById(Integer id);

    /**
     * 查询所有用户信息
     */
    public List<User> selectAll();

    /**
     * 条件查询用户，参数传入一个 Map 集合
     */
    public List<User> dynamicUser(Map<String,Object> map);

    /**
     * 动态传参更新用户信息
     */
    public Integer updateUser(Map<String,Object> map);

    /**
     * 查询满足 id 在一个区间内的用户信息
     */
    public List<User> findIds(@Param("ids") List<Integer> ids);

    /**
     * 传入多个条件选择其中一个条件查询用户信息，参数传入一个 Map 集合，sql 语句用 choose 标签（相当于 switch）
     */
    public List<User> chooseUser(Map<String,Object> map);

    /**
     * 根据 id 删除用户信息
     */
    public Integer deleteUserById(Integer id);
}
