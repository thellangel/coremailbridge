package com.hdsoft.coremailbridge.persistence;

import com.hdsoft.coremailbridge.model.Mail;
import com.hdsoft.coremailbridge.model.MailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_mail
     *
     * @mbggenerated Sun Oct 16 17:21:00 CST 2022
     */
    int countByExample(MailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_mail
     *
     * @mbggenerated Sun Oct 16 17:21:00 CST 2022
     */
    int deleteByExample(MailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_mail
     *
     * @mbggenerated Sun Oct 16 17:21:00 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_mail
     *
     * @mbggenerated Sun Oct 16 17:21:00 CST 2022
     */
    int insert(Mail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_mail
     *
     * @mbggenerated Sun Oct 16 17:21:00 CST 2022
     */
    int insertSelective(Mail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_mail
     *
     * @mbggenerated Sun Oct 16 17:21:00 CST 2022
     */
    List<Mail> selectByExampleWithBLOBs(MailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_mail
     *
     * @mbggenerated Sun Oct 16 17:21:00 CST 2022
     */
    List<Mail> selectByExample(MailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_mail
     *
     * @mbggenerated Sun Oct 16 17:21:00 CST 2022
     */
    Mail selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_mail
     *
     * @mbggenerated Sun Oct 16 17:21:00 CST 2022
     */
    int updateByExampleSelective(@Param("record") Mail record, @Param("example") MailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_mail
     *
     * @mbggenerated Sun Oct 16 17:21:00 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") Mail record, @Param("example") MailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_mail
     *
     * @mbggenerated Sun Oct 16 17:21:00 CST 2022
     */
    int updateByExample(@Param("record") Mail record, @Param("example") MailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_mail
     *
     * @mbggenerated Sun Oct 16 17:21:00 CST 2022
     */
    int updateByPrimaryKeySelective(Mail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_mail
     *
     * @mbggenerated Sun Oct 16 17:21:00 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(Mail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coremailbridge_mail
     *
     * @mbggenerated Sun Oct 16 17:21:00 CST 2022
     */
    int updateByPrimaryKey(Mail record);
}