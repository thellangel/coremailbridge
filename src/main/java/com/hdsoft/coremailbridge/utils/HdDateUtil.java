package com.hdsoft.coremailbridge.utils;
////////////////////////////////////////////////////////////////////////////
///  COPYRIGHT NOTICE
///  Copyright: Copyright (c)  2012
///  Company: www.quanshi.com 
///  ALL rights reserved
///
///  @file  DateUtil.java
///  @date  2012-9-11
///  @author  tingting.deng@quanshi.com
///  @version 1.0
////////////////////////////////////////////////////////////////////////////



import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @brief 日期操作工具类
 */
public class HdDateUtil {
	/**yyyy-MM-dd HH:mm:ss **/
	public static final String format0 = "yyyy-MM-dd HH:mm:ss";
	/** yyyy-MM-dd **/
	public static final String format1 = "yyyy-MM-dd";
	/** yyyy-MM **/
	public static final String format2 = "yyyy-MM";// /<获取某一月的第一天
	/** yyyy-MM-dd HH:mm **/
	public static final String format3 = "yyyy-MM-dd HH:mm";// /<
	/** yyyyMM **/
	public static final String format4 = "yyyyMM";
	/** yyyyMMdd **/
	public static final String yyyyMMdd = "yyyyMMdd";
	/** yyyyMMddHHmm **/
	public static final String yyyyMMddHHmm = "yyyyMMddHHmm";
	/** yyyyMMddHHmmss **/
	public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
	/** %Y-%m-%d %h:%m:%s **/
	public static final String format0_mysql = "%Y-%m-%d %h:%m:%s";// /<%Y-%m-%d
	/** %Y-%m-%d **/															// %h:%m:%s
	public static final String format1_mysql = "%Y-%m-%d ";// /<%Y-%m-%d
															// %h:%m:%s
	// 时间比较（0：比较错误，1：date1小于date2，2：date1 等于date2，3：date1 大于date2）
	public static final Short DATE_COMPARE_EXCEPTION = 0;// /<0：比较错误
	public static final Short DATE_COMPARE_SMALL = 1;// /<1：date1小于date2
	public static final Short DATE_COMPARE_EQUAL = 2;// /<2：date1 等于date2
	public static final Short DATE_COMPARE_BIG = 3;// /<3：date1 大于date2

	/**
	 * 
	 * @brief 获取当前时间
	 * @return Date
	 */
	public static Date getNow() {
		return new Date(System.currentTimeMillis());

	}

	public static long getCurrentTimeMillis() {
		return System.currentTimeMillis();
	}

	public static Date getToday() {
		return HdDateUtil.parserDate(
				HdDateUtil.getFormateDateString(getNow(), format1), format1);

	}

	public static Timestamp getTimeStamp(Date date) {
		if (null == date)
			return null;
		return new Timestamp(date.getTime());
	}

	/**
	 * 
	 * @brief 判断date1，date2是不是同一个月份
	 * @param date1
	 * @param date2
	 * @return boolean
	 */
	public static boolean compareInSameMonth(Date date1, Date date2) {
		if (null == date1 || null == date2)
			return false;
		if (getFirstDayStringOfMonth(date1).equals(
				getFirstDayStringOfMonth(date2)))
			return true;
		return false;
	}

	/**
	 * 
	 * @brief (用于method的简易说明)
	 * 
	 * @param date1
	 * @param date2
	 * @return boolean
	 */
	public static boolean compareInSameDay(Date date1, Date date2) {
		if (null == date1 || null == date2)
			return false;
		String dateString1 = getFormateDateString(date1, format1);
		String dateString2 = getFormateDateString(date2, format1);
		if (dateString1.equals(dateString2)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @brief 比较两个时间点哪个大？
	 * @param date1
	 * @param date2
	 * @return int （0：比较错误，1：date1小于date2，2：date1 等于date2，3：date1 大于date2）
	 */
	public static short compareDateTime(Date date1, Date date2) {

		if (null == date1 || null == date2) {// 0
			return DATE_COMPARE_EXCEPTION;
		}
		if (date1.getTime() > date2.getTime()) {// 3
			return DATE_COMPARE_BIG;
		}
		if (date1.getTime() == date2.getTime()) {// 2
			return DATE_COMPARE_EQUAL;
		}
		if (date1.getTime() < date2.getTime()) {// 1
			return DATE_COMPARE_SMALL;
		}
		return DATE_COMPARE_EXCEPTION;
	}

	/**
	 * 
	 * @brief 判断date1，date2是不是同一个月份（例如2012-01-01的月份要大于2011-12-01）
	 * @param date1
	 * @param date2
	 * @return int （0：比较错误，1：date1小于date2，2：date1 等于date2，3：date1 大于date2）
	 */
	public static short compareMonth(Date date1, Date date2) {
		if (null == date1 || null == date2)
			return DATE_COMPARE_EXCEPTION;
		return compareDay(getFirstDayOfMonth(date1), getFirstDayOfMonth(date2));
	}

	/**
	 * 
	 * @brief 将日期转换成对应格式的Date
	 * @param date
	 * @param format
	 * @return String
	 */
	public static Date getFormateDate(Date date, String format) {
		if (null == date || null == format)
			return null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String dateString = dateFormat.format(date);
		return parserDate(dateString, format);
	}

	/**
	 * 
	 * @brief 判断date1与date2是不是同一天
	 * @param date1
	 * @param date2
	 * @return int
	 */
	public static short compareDay(Date date1, Date date2) {
		if (null == date1 || null == date2)
			return DATE_COMPARE_EXCEPTION;
		// 将date1，date2格式化成format1的格式
		date1 = getFormateDate(date1, format1);
		date2 = getFormateDate(date2, format1);
		if (null == date1 || null == date2)
			return DATE_COMPARE_EXCEPTION;
		if (date1.getTime() > date2.getTime())
			return DATE_COMPARE_BIG;
		if (date1.getTime() == date2.getTime())
			return DATE_COMPARE_EQUAL;
		if (date1.getTime() < date2.getTime())
			return DATE_COMPARE_SMALL;
		return DATE_COMPARE_EXCEPTION;
	}

	/**
	 * @brief 字符串按特定格式转日期
	 * @param str
	 *            日期 如 "yyyy-MM-dd" 或 "yyyy-MM-dd HH:mm:ss"
	 * @param format
	 * @return
	 */
	public static Date parserDate(String str, String format) {
		if (null == str || "".equals(str) || "NULL".equalsIgnoreCase(str))
			return null;
		if (null == format)
			format = format0;

		java.util.Date d = Calendar.getInstance().getTime();
		if (str.length() == 10)
			str = str + " 00:00:00";
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		ParsePosition pos = new ParsePosition(0);
		d = formatter.parse(str, pos);
		return d;
	}

	/**
	 * 
	 * @brief 将日期转换成对应格式的字符串
	 * @param date
	 * @param format
	 * @return String
	 */
	public static String getFormateDateString(Date date, String format) {
		if (date == null)
			return null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	/**
	 * @brief 字符串按特定格式转日期
	 * @param str
	 *            日期 如 "yyyy-MM-dd" 或 "yyyy-MM-dd HH:mm:ss"
	 * @return
	 */
	public static Date parserDate(String str) {
		if (null == str)
			return null;
		return parserDate(str, format0);
	}

	/**
	 * 
	 * @brief 获取date日期所在的月份的第一天
	 * @param date
	 * @return Date
	 */
	public static Date getFirstDayOfMonth(Date date) {
		if (null == date)
			return null;
		return parserDate(getFirstDayStringOfMonth(date), format2);
	}

	/**
	 * 
	 * @brief 获取date日期所在的月份的第一天
	 * @param date
	 * @return String
	 */
	public static String getFirstDayStringOfMonth(Date date) {
		if (null == date)
			return null;
		return getFormateDateString(date, format2);
	}

	/**
	 * 
	 * @brief 获取当前时间时间戳
	 * @return Timestamp
	 */
	public static Timestamp getNowTimeStamp() {
		// return System.currentTimeMillis();
		return new Timestamp(getNow().getTime());

	}

	/**
	 * 
	 * @brief 在date的基础上增加多少天
	 * @param date
	 * @param day
	 * @return Date
	 */
	public static Date addDay(Date date, Integer day) {
		if (null == date || null == day)
			return null;
		return addHours(date, 24 * day);
	}

	/**
	 * 
	 * @brief 在date的基础上增加多少小时
	 * @param date
	 * @param hour
	 * @return Date
	 */
	public static Date addHours(Date date, Integer hour) {
		if (null == date || null == hour)
			return null;
		return addMinutes(date, 60 * hour);
	}

	/**
	 * 
	 * @brief 在date的基础上增加多少分钟
	 * @param date
	 * @param minutes
	 * @return Date
	 */
	public static Date addMinutes(Date date, Integer minutes) {
		if (null == date || null == minutes)
			return null;
		return addSeconds(date, 60 * minutes);
	}

	/**
	 * 
	 * @brief 在date的基础上增加多少秒
	 * @param date
	 * @param second
	 * @return Date
	 */
	public static Date addSeconds(Date date, Integer second) {
		if (null == date || null == second)
			return null;
		return addTimes(date, 1000L * second);
	}

	/**
	 * 
	 * @brief 在date的基础上增加多少毫秒
	 * @param date
	 * @param times
	 * @return Date
	 */
	public static Date addTimes(Date date, Long times) {
		if (null == date || null == times)
			return null;

		long resultTime = date.getTime() + times;
		// date.setTime(resultTime);
		Date resultDate = new Date(resultTime);
		return resultDate;
	}

	/**
	 * @brief 计算两个日期之间所差天数
	 * @param date1
	 *            日期1
	 * @param date2
	 *            日期2
	 * @return 返回天数
	 * @author leilei.liu
	 */
	public static long diffDays(Date date1, Date date2) {
		return date1.getTime() / 86400000 - date2.getTime() / 86400000;
		// if(date1.getTime() > date2.getTime()) {
		// return date1.getTime()/86400000 - date2.getTime()/86400000;
		// } else {
		// return date2.getTime()/86400000 - date1.getTime()/86400000;
		// }

	}

	/**
	 * @brief 获取会议时长
	 * @param endTime
	 *            会议结束时间
	 * @param startTime
	 *            会议开始时间
	 * @return 会议持续时长
	 */
	public static long getDuration(String endTime, String startTime) {
		Date startDate = HdDateUtil.parserDate(startTime);
		Date endDate = HdDateUtil.parserDate(endTime);
		long diff = endDate.getTime() - startDate.getTime();
		long duration = diff / (1000 * 60);
		return duration;
	}

	/**
	 * @brief 获取指定日期的上月一号
	 * @param date
	 *            指定日期
	 * @return 上月日期
	 * @author leilei.liu
	 */
	public static Date getLastMonth(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		// 调到上个月
		cal.add(Calendar.MONTH, -1);
		// 按要求设置时间
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);

		return cal.getTime();

	}

	/**
	 * @brief 获取指定日期的上月字符串
	 * @param date
	 *            指定日期
	 * @param format
	 *            格式
	 * @return 上月日期
	 */
	public static String getLastMonth(Date date, String format) {
		return HdDateUtil.getFormateDateString(HdDateUtil.getLastMonth(date),
				format);
	}

	/**
	 * @brief 获取指定日期的前一天
	 * @param date
	 *            指定日期
	 * @return 前一天
	 * @author leilei.liu
	 */
	public static Date getLastDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.add(Calendar.DAY_OF_MONTH, -1);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
		return cal.getTime();
	}

	/**
	 * @brief 减去指定月份
	 * @param date
	 *            指定日期
	 * @param length
	 *            要减去的月份数
	 * @return 得到日期
	 * @author leilei.liu
	 */
	public static Date subMonth(Date date, int length) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		// 调整月份
		cal.add(Calendar.MONTH, -length);
		// 按要求设置时间
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);

		return cal.getTime();
	}

	/**
	 * @brief 添加指定月份
	 * @param date
	 *            指定日期
	 * @param length
	 *            要增加的月份数（负数，表示减去的月份数）
	 * @return 得到日期
	 * @author leilei.liu
	 */
	public static Date addMonth(Date date, int length) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		// 调整月份
		cal.add(Calendar.MONTH, length);
		// 按要求设置时间
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);

		return cal.getTime();
	}

	/**
	 * 
	 * @brief 将字符串的时间类型转成符合某格式的字符串时间类型
	 * 
	 * @param date
	 * @param format
	 * @return String
	 */
	public static String formatDateString(String date, String format) {
		Date date1 = HdDateUtil.parserDate(date, format);
		return HdDateUtil.getFormateDateString(date1, format);
	}
	
	public static String getStringFromDate(Date date) {
        if (date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sdf.format(date);
    }
	
	public static String getStringFromDate(Date date, String format) {
        if (date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
	
}
