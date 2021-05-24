package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserDao{
    // ���� id ��ѯ�û���Ϣ
	@Select("SELECT * FROM user01 WHERE username = #{username}")
    public User findUserById(String username);
}