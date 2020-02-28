package com.july.shop.member.mapper;

import com.july.shop.api.member.entity.UserDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;

/**
 * @author july
 * @description: 用户Mapper
*/
public interface UserMapper {

	@Insert("INSERT INTO `t_user` (mobile, email, password, user_name) VALUES (#{mobile}, #{email}, #{password}, #{userName});")
	int register(UserDo userEntity);

	@Select("SELECT * FROM t_user WHERE MOBILE=#{mobile};")
	UserDo existMobile(@Param("mobile") String mobile);

	@Select("SELECT USER_ID AS USERID ,MOBILE AS MOBILE,EMAIL AS EMAIL,PASSWORD AS PASSWORD, USER_NAME AS USER_NAME ,SEX AS SEX ,AGE AS AGE ,CREATE_TIME AS CREATETIME,IS_AVALIBLE AS ISAVALIBLE,PIC_IMG AS PICIMG,QQ_OPENID AS QQOPENID,WX_OPENID AS WXOPENID "
			+ "  FROM t_user  WHERE MOBILE=#{0} and password=#{1};")
	UserDo login(@Param("mobile") String mobile, @Param("password") String password);

	@Select("SELECT USER_ID AS USERID ,MOBILE AS MOBILE,EMAIL AS EMAIL,PASSWORD AS PASSWORD, USER_NAME AS USER_NAME ,SEX AS SEX ,AGE AS AGE ,CREATE_TIME AS CREATETIME,IS_AVALIBLE AS ISAVALIBLE,PIC_IMG AS PICIMG,QQ_OPENID AS QQOPENID,WX_OPENID AS WXOPENID"
			+ " FROM t_user WHERE user_Id=#{userId}")
	UserDo findByUserId(@Param("userId") Long userId);

	@Select("SELECT USER_ID AS USERID ,MOBILE AS MOBILE,EMAIL AS EMAIL,PASSWORD AS PASSWORD, USER_NAME AS USER_NAME ,SEX AS SEX ,AGE AS AGE ,CREATE_TIME AS CREATETIME,IS_AVALIBLE AS ISAVALIBLE,PIC_IMG AS PICIMG,QQ_OPENID AS QQOPENID,WX_OPENID AS WXOPENID"
			+ " FROM t_user WHERE qq_openid=#{qqOpenId}")
	UserDo findByOpenId(@Param("qqOpenId") String qqOpenId);

	@Update("update t_user set QQ_OPENID =#{0} WHERE USER_ID=#{1}")
	int updateUserOpenId(@Param("qqOpenId") String qqOpenId, @Param("userId") Long userId);
}
