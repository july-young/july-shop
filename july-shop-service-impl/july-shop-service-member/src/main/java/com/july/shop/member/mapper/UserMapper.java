package com.july.shop.member.mapper;

import com.july.shop.api.member.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

/**
 * @author july
 * @description: 用户Mapper
*/
public interface UserMapper {

	@Insert("INSERT INTO `t_user` (mobile, email, password, user_name) VALUES (#{mobile}, #{email}, #{password}, #{userName});")
	int register(UserEntity userEntity);

	@Select("SELECT * FROM t_user WHERE MOBILE=#{mobile};")
	UserEntity existMobile(@Param("mobile") String mobile);
}
