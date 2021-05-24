package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserDao{
    // 根据 id 查询用户信息
	@Select("SELECT * FROM user01 WHERE username = #{username}")
    public User findUserById(String username);
}