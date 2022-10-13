package com.hdsoft.coremailbridge.persistence;

import java.util.List;

import com.hdsoft.coremailbridge.model.User;
import com.hdsoft.coremailbridge.model.UserExample;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_user
     *
     * @mbggenerated Sat Jan 19 09:51:17 CST 2019
     */
    int countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_user
     *
     * @mbggenerated Sat Jan 19 09:51:17 CST 2019
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_user
     *
     * @mbggenerated Sat Jan 19 09:51:17 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_user
     *
     * @mbggenerated Sat Jan 19 09:51:17 CST 2019
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_user
     *
     * @mbggenerated Sat Jan 19 09:51:17 CST 2019
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_user
     *
     * @mbggenerated Sat Jan 19 09:51:17 CST 2019
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_user
     *
     * @mbggenerated Sat Jan 19 09:51:17 CST 2019
     */
    User selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_user
     *
     * @mbggenerated Sat Jan 19 09:51:17 CST 2019
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_user
     *
     * @mbggenerated Sat Jan 19 09:51:17 CST 2019
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_user
     *
     * @mbggenerated Sat Jan 19 09:51:17 CST 2019
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_user
     *
     * @mbggenerated Sat Jan 19 09:51:17 CST 2019
     */
    int updateByPrimaryKey(User record);
}