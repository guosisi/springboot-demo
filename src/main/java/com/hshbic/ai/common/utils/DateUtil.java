package com.hshbic.ai.common.utils;

import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 各种日期操作
 * 
 */
public class DateUtil {
	private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static final String BENTIME = "yyyy-MM-dd 00:00:00";
	
	public static final String ENDTIME = "yyyy-MM-dd 23:59:59";
	

	/**
	 * 日期的算术操作，可以增加或者减少，可以某一部分进行操作 year--年 month-月 1-12 day-天 1-31 hour -小时 0-23
	 * minute 分钟 0-59 second 秒 0-59 millisecond 毫秒 显示格式，可以任意组合
	 * 
	 * G Era designator Text AD y Year Year 1996; 96 M Month in year Month July;
	 * Jul; 07 w Week in year Number 27 W Week in month Number 2 D Day in year
	 * Number 189 d Day in month Number 10 F Day of week in month Number 2 E Day
	 * in week Text Tuesday; Tue a Am/pm marker Text PM H Hour in day (0-23)
	 * Number 0 k Hour in day (1-24) Number 24 K Hour in am/pm (0-11) Number 0 h
	 * Hour in am/pm (1-12) Number 12 m Minute in hour Number 30 s Second in
	 * minute Number 55 S Millisecond Number 978 z Time zone General time zone
	 * Pacific Standard Time; PST; GMT-08:00 Z Time zone RFC 822 time zone -0800
	 * 
	 * @param srcDate
	 * @param srcFormat
	 * @param destFormat
	 * @param operType
	 * @param operValue
	 * @return
	 */
	public static String evalTime(Date srcDate, String destFormat, String operType, int operValue) {
		if (srcDate == null || srcDate.equals(""))
			return "";
		if (destFormat == null || destFormat.equals(""))
			destFormat = "yyyy-MM-dd";
		if (operType == null || operType.equals(""))
			operType = "day";

		// Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("AST"));
		Calendar cal = Calendar.getInstance();
		cal.setTime(srcDate);
		if (operType.equals("year")) {
			cal.add(Calendar.YEAR, operValue);
		} else if (operType.equals("month")) {
			cal.add(Calendar.MONTH, operValue);
		} else if (operType.equals("day")) {
			cal.add(Calendar.DAY_OF_MONTH, operValue);
		} else if (operType.equals("hour")) {
			cal.add(Calendar.HOUR_OF_DAY, operValue);
		} else if (operType.equals("minute")) {
			cal.add(Calendar.MINUTE, operValue);
		} else if (operType.equals("second")) {
			cal.add(Calendar.SECOND, operValue);
		} else if (operType.equals("millisecond")) {
			cal.add(Calendar.MILLISECOND, operValue);
		}
		String curDay = new SimpleDateFormat(destFormat).format(cal.getTime());
		return curDay;
	}

	/**
	 * 功能描述:获取指定最近几天的日期
	 * @param date 指定日期
	 * @param destFormat 格式化
	 * @param operValue 指定往前推几天
	 * @return
	 */
    public static String[] lastDayAry(Date date,String destFormat,int operValue,boolean currentDay){
    	String[]days=new String[operValue];
    	for(int i=0;i<operValue;i++){
    		if(currentDay)
    			days[operValue-1-i]=evalTime(date,destFormat,"day",-i);
    		else
    			days[operValue-1-i]=evalTime(date,destFormat,"day",-1-i);
    	}
    	return days;
    }

	/**
	 * 日期格式转化 转换为时间戳类型
	 *
	 * @param sdate
	 * @return
	 * @throws ParseException
	 */
	/*public static Timestamp string2Time(String sdate) throws ParseException {
		java.sql.Timestamp d = null;
		java.util.Date d1 = new SimpleDateFormat(Constant.TIMEFORMAT, Locale.getDefault()).parse(sdate);
		d = new java.sql.Timestamp(d1.getTime());
		String d2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(d);
		Timestamp.valueOf(d2);
		return d;
	}*/

	/**
	 * 获得当前时间 转换为时间戳类型
	 *
	 * @param
	 * @return
	 * @throws ParseException
	 */
	public static Timestamp getCurTime2Timestamp() throws ParseException {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		String d2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(t);
		Timestamp.valueOf(d2);
		return t;
	}

	/**
	 * 将时间格式化
	 *
	 * @return
	 */
	public static Date DatePattern(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
		try {
			String dd = sdf.format(date);
			date = stringToDate(dd);
		} catch (Exception e) {
		}
		return date;
	}

	/**
	 * 日期格式转化
	 *
	 * @param srcDate
	 * @param srcFormat
	 * @param destFormat
	 * @return
	 */
	public static String dateFormat(String srcDate, String srcFormat, String destFormat) {
		if (srcFormat == null || srcFormat.equals(""))
			srcFormat = "yyyy-MM-dd";
		if (destFormat == null || destFormat.equals(""))
			destFormat = "yyyy-MM-dd";
		if (srcDate == null || srcDate.equals(""))
			return "";

		Calendar cal = Calendar.getInstance();
		Date currentTime = null;
		try {
			currentTime = (Date) new SimpleDateFormat(srcFormat).parse(srcDate);
		} catch (ParseException e) {
			currentTime = new Date();
		}
		cal.setTime(currentTime);
		String curDay = new SimpleDateFormat(destFormat).format(cal.getTime());
		return curDay;
	}

	/**
	 * 获取星期
	 * @param date
	 * @param language
	 * @return
	 */

	public static String dayForWeek(Date date,String language) {
		String[] weekDays = {"星期日","星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
		 Calendar c = Calendar.getInstance();
		 c.setTime(date);
		 int dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		 return language==null?String.valueOf(dayForWeek):weekDays[dayForWeek];
	}

	/**
	 * 日期格式转化
	 *
	 * @param srcDate
	 * @param destFormat
	 * @return
	 */
	public static String dateFormat(Date srcDate, String destFormat) {
		if (srcDate == null)
			return "";
		if (destFormat == null || destFormat.equals(""))
			destFormat = "yyyy-MM-dd";
		String curDay = new SimpleDateFormat(destFormat).format(srcDate);
		return curDay;
	}

	/**
	 * 日期格式转化
	 *
	 * @return
	 */
	public static String currentDateFormat() {
		return currentDateFormat("yyyyMMdd");
	}

	/**
	 * 日期格式转化
	 *
	 * @param destFormat
	 * @return
	 */
	public static String currentDateFormat(String destFormat) {
		String curDay = new SimpleDateFormat(destFormat).format(new Date());
		return curDay;
	}

	/**
	 * 字符串日期转化为java.util.Date
	 *
	 * @param srcDate
	 * @param srcFormat
	 * @return
	 */
	public static Date stringToDate(String srcDate, String srcFormat) {
		if (srcDate == null || srcDate.equals(""))
			return null;
		if (srcFormat == null || srcFormat.equals(""))
			srcFormat = "yyyy-MM-dd";
		Calendar cal = Calendar.getInstance();
		Date currentTime = null;
		try {
			currentTime = (Date) new SimpleDateFormat(srcFormat).parse(srcDate);
		} catch (ParseException e) {
			currentTime = new Date();
		}
		cal.setTime(currentTime);
		return cal.getTime();
	}
	/**
	 * 将字符串格式化为‘yyyy-MM-dd HH:mm:ss’格式的java.util.Date
	 */
	public static Date stringToDate(String srcDate) {
		if (srcDate == null || srcDate.equals(""))
			return null;
		Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
		try {
			d = sdf.parse(srcDate);
		} catch (Exception e) {
		}
		return d;
	}

	 /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getCurrYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

	/**
     * 获取某年最后一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getCurrYearLast(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }

    /**
     * 获取某月的第一天
     * @param date
     * @return
     */
    public static Date getFirstday(Date date){
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Date theDate = calendar.getTime();

        //这个月第一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        Date day_first = gcLast.getTime();
    	return day_first;
    }
    /**
     * @Description:  TODO(获取今日与本周一差几天)
     * @return:       int
     * @author        fangrui
     * @Date          2016年4月6日 下午5:13:54
     */
    public static int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            return -6;
        } else {
            return 2 - dayOfWeek;
        }
    }
    /**
     * @Description:  TODO(获取当前周周一的时间)
     * @return:       String
     * @author        fangrui
     * @Date          2016年4月6日 下午5:12:31
     */
    public static  String getCurrentMonday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();
        String preMonday = dateFormat(monday,"yyyyMMdd");
        return preMonday;
    }

    /**
     * 获取某月的最后一天
     * @param date
     * @return
     */
    public static Date getLastday(Date date){
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);        //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天

        Date day_last = calendar.getTime();
    	return day_last;
    }

	/**
	 * 比较两个日期的大小
	 */
	public static boolean compare(Date d1, Date d2) {
		if (d1.after(d2)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 名称：dateToStr
	 * 功能：将指定的日期转换成字符串
	 * 输入：aDteValue: 要转换的日期;
	 * aFmtDate: 转换日期的格式, 默认为:"yyyy/MM/dd"
	 * 输出：
	 * 返回：转换之后的字符串
	 */
	public static String dateToStr(Date aDteValue, String aFmtDate) {
		String strRtn = null;

		if (aFmtDate.length() == 0) {
			aFmtDate = "yyyy/MM/dd";
		}
		Format fmtDate = new SimpleDateFormat(aFmtDate);
		try {
			strRtn = fmtDate.format(aDteValue);
		} catch (Exception e) {
		}

		return strRtn;
	}

	/**
	 * 名称：strToDate
	 * 功能：将指定的字符串转换成日期
	 * 输入：aStrValue: 要转换的字符串;
	 * aFmtDate: 转换日期的格式, 默认为:"yyyy/MM/dd"
	 * aDteRtn: 转换后的日期
	 * 输出：
	 * 返回：TRUE: 是正确的日期格式; FALSE: 是错误的日期格式
	 */
	public static boolean strToDate(String aStrValue, String aFmtDate, Date aDteRtn) {
		if (aFmtDate.length() == 0) {
			aFmtDate = "yyyy/MM/dd";
		}
		SimpleDateFormat fmtDate = new SimpleDateFormat(aFmtDate);
		try {
			aDteRtn.setTime(fmtDate.parse(aStrValue).getTime());
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * 格式化时间（字符串格式：yyyy-MM-dd HH:mm:ss）
	 *
	 * @param date
	 * @return
	 */
	public static String date2String(Date date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(date);
	}

	/**
	 * 当前时间（字符串格式：yyyy-MM-dd HH:mm:ss）
	 *
	 * @return
	 */
	public static String currentTime() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(new Date());
	}



	/**
	 * 当前时间（字符串格式：yyyyMMdd ）
	 *  add by suyang
	 * @return
	 */
	public static String getTime() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		return sf.format(new Date());
	}

	/**
	 * java.util.Date转化为java.sql.Date
	 */
	public static java.sql.Date parseSqlDate(Date date) {
		if (date == null)
			return null;
		return new java.sql.Date(date.getTime());
	}

	/**
	 * java.util.Date转化为java.sql.Timestamp
	 */
	public static Timestamp parseTimestamp(Date date, String format) {
		if (date == null)
			return null;
		long t = date.getTime();
		return new Timestamp(t);
	}

	/**
     * 字符串转换为Date类型日期
     *
     * @param date 日期字符串
     * @param format 日期字符串的现有格式
     * @return 日期
     * @throws ParseException 异常
     */
    public static Date formatDate(String date, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(date);
    }

	/**
     * 获取日期差
     *
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @param startDateFormat 开始时间字符串格式
     * @param endDateFormat 结束时间字符串格式
     * @param divisor 设置除数，返回对应的时间差（日(24*60*60*1000)、小时(60*60*1000)、分钟(60 * 1000)、秒(1000)）
     * @return 日期差
     * @throws ParseException 异常
     */
    public static long getDateSubtract(String startDate, String startDateFormat, String endDate, String endDateFormat, int divisor)
        throws ParseException {
        Date start = formatDate(startDate, startDateFormat);
        Date end = formatDate(endDate, endDateFormat);
        return getDateSubtract(start, end, divisor);
    }

	/**
     * 获取日期差
     *
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @param divisor 设置除数，返回对应的时间差（日(24*60*60*1000)、小时(60*60*1000)、分钟(60 * 1000)...）
     * @return 日期差
     * @throws ParseException 异常
     */
    public static long getDateSubtract(Date startDate, Date endDate, int divisor) {
        return diffDate(startDate , endDate) / divisor;
    }

	/**
	 * 日期相减
	 *
	 * @param date
	 *            日期
	 * @param date1
	 *            日期
	 * @return 返回相减后的日期
	 */
	public static long diffDate(Date date, Date date1) {
		if (date == null)
			return 0;
		if (date1 == null)
			return 0;
		return date.getTime() - date1.getTime();
	}

	/**
	 * 针对年月取出最大的天数
	 */
	/*public static String getMaxDay(String yearmonth) {
		String tmp = evalTime(yearmonth, "yyyyMM", "yyyyMM", "month", 1);
		String tmp2 = tmp + "01";
		String tmp3 = evalTime(tmp2, "yyyyMMdd", "dd", "day", -1);
		return tmp3;
	}*/

	/**
	 * 针对下月月初日期 modify by jiangmm 20091204
	 */
	public static String getNextBeginDay() {
		Calendar cal = Calendar.getInstance();
		@SuppressWarnings("unused")
		String endDate_year = String.valueOf(cal.get(Calendar.YEAR));
		@SuppressWarnings("unused")
		String endDate_month = "";
		if (cal.get(Calendar.MONTH) + 1 < 10) {
			endDate_month = "0" + (cal.get(Calendar.MONTH) + 1);
		} else {
			endDate_month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		}
		@SuppressWarnings("unused")
		String endDate_day = String.valueOf(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		String effDate_year = "";
		String effDate_month = "";
		// 当月为12月时，下月应该为下一年的1月，下个月的年份应该加1
		if (cal.get(Calendar.MONTH) + 1 == 12) {
			effDate_year = String.valueOf(cal.get(Calendar.YEAR) + 1);
			effDate_month = "01";
		} else {
			effDate_year = String.valueOf(cal.get(Calendar.YEAR));
			// 当下月为小于10月时，应该为下月的前面加0，如02到09
			if (cal.get(Calendar.MONTH) + 2 < 10) {
				effDate_month = "0" + (cal.get(Calendar.MONTH) + 2);
			} else {
				effDate_month = String.valueOf(cal.get(Calendar.MONTH) + 2);
			}
		}

		String effDate = effDate_year + effDate_month + "01";// 更改后套餐生效日期
		return effDate;
	}

	/**
	 * 判断是否是闰年
	 */
	public boolean isLeapyear(int year) {

		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获得当前月份 转换为Long类型
	 * @throws ParseException
	 */
	public static Long getCurMonthLong() throws ParseException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		// t_log_echn_servinvoke.setTime_range(Long.valueOf(sdf.format(date)));
		return Long.parseLong(sdf.format(date));
	}

	/**
	 * 获取当前时间的时间戳
	 * @return
	 */
	public static long getDateByTime(){
		return new Date().getTime();
	}

	public static String date2Str(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 比较时间是否在这两个时间点之间
	 *
	 * @param time1
	 * @param time2
	 */
	public static boolean checkTime(String time1, String time2) {
		Calendar calendar = Calendar.getInstance();
		Date date1 = calendar.getTime();
		Date date11 = DateUtil.stringToDate(DateUtil.dateToStr(date1, "yyyy-MM-dd") + " " + time1, DEFAULT_PATTERN);// 起始时间
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		Date date2 = c.getTime();
		Date date22 = DateUtil.stringToDate(DateUtil.dateToStr(date2, "yyyy-MM-dd") + " " + time2, DEFAULT_PATTERN);// 终止时间
		Calendar scalendar = Calendar.getInstance();
		scalendar.setTime(date11);// 起始时间
		Calendar ecalendar = Calendar.getInstance();
		ecalendar.setTime(date22);// 终止时间
		Calendar calendarnow = Calendar.getInstance();
		if (calendarnow.after(scalendar) && calendarnow.before(ecalendar)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 判断日期 date1-当前时间 date2-失效时间 delay-时间阀值（天数） return true-即将失效，提醒 false-未失效
	 */
	public static boolean toRemind(Date date1, Date date2, int delay) {

		Long time = DateUtil.diffDate(date1, date2);
		if (delay > time / (60 * 60 * 24 * 1000)) {
			return false;// 未失效
		} else {
			return true;// 即将失效，提醒
		}
	}

	/**
	 * 获得上一个月的月份
	 *
	 */
	public static Calendar getPreviousMonth(Calendar cal) {
		//String str = "";
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");

		if (cal == null) {
			cal = Calendar.getInstance();
		}
		cal.add(Calendar.MONTH, -1);//减一个月，变为下月的1号
		return cal;
	}

	/**
	 * 根据日期类型更改时间
	 *
	 * @param date
	 *            日期
	 * @param type
	 *            类型.month|date|year
	 * @param value
	 *            更改值大小
	 * @return 返回变更后的日期
	 */
	public static Date changeDate(Date date, String type, int value) {
		// Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		// Calendar calendar = Calendar.
		if (type.equals("month")) {
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + value);
		} else if (type.equals("date")) {
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + value);
		} else if (type.endsWith("year")) {
			calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + value);
		}
		return calendar.getTime();
	}


	/**
	 * @author zhaoweia
	 * 月份相减
	 * @param startDate
	 * @param enDate
	 * @return startDate - enDate
	 */
	public static int divMonth(Date startDate, Date enDate) {
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);

		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(enDate);

		int yearDiv = startCalendar.get(Calendar.YEAR) - endCalendar.get(Calendar.YEAR);

		int monthDiv = startCalendar.get(Calendar.MONTH) - endCalendar.get(Calendar.MONTH);

		return monthDiv + yearDiv * 12;
	}
	/**
	 * @author jiangmm
	 * 获取当前时间的前几个月的月份  不包括本月
	 * @param count 指要取多少个月份
	 * @return datelist List<String>
	 */
	public static List getPreMonths(int count){
		//Calendar 与 Date 的转换
		Calendar calendar = Calendar.getInstance();
		// 从一个 Calendar 对象中获取 Date 对象
		Date date = calendar.getTime();
		// 将 Date 对象反应到一个 Calendar 对象中，
		// Calendar/GregorianCalendar 没有构造函数可以接受 Date 对象
		// 所以我们必需先获得一个实例，然后设置 Date 对象
		calendar.setTime(date);

		List datelist=new ArrayList();
		for(int i=0;i<count;i++){
			calendar=DateUtil.getPreviousMonth(calendar);
			Date date2 = calendar.getTime();
			String date3 =DateUtil.date2Str(date2, "yyyyMM");
			//logger.debug("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+date3);
			datelist.add(date3);
		}
		return datelist;
	}
	/**
	 * @author jiangmm
	 * 获取当前时间的前几个月的月份  包括本月
	 * @param count 指要取多少个月份
	 * @return datelist List<String>
	 */
	public static List getFormNowMonths(int count){
		//Calendar 与 Date 的转换
		Calendar calendar = Calendar.getInstance();
		// 从一个 Calendar 对象中获取 Date 对象
		Date date = calendar.getTime();
		// 将 Date 对象反应到一个 Calendar 对象中，
		// Calendar/GregorianCalendar 没有构造函数可以接受 Date 对象
		// 所以我们必需先获得一个实例，然后设置 Date 对象
		calendar.setTime(date);

		List datelist=new ArrayList();
		for(int i=0;i<count;i++){
			Date date2 = calendar.getTime();
			String date3 =DateUtil.date2Str(date2, "yyyyMM");
			//logger.debug("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+date3);
			datelist.add(date3);
			calendar=DateUtil.getPreviousMonth(calendar);
		}
		return datelist;
	}

	/**
	 * 当前年月（字符串格式：yyyyMM）
	 * @return
	 */
	public static String getCurrentYearMonth()
	{
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
		return sf.format(new Date());
	}
	/**
	 *
	  * 方法功能：当前年的上个月 <BR>
	  * @return
	  * @since
	 */
	public static String getLastYearMonth()
	{
		 Calendar cal = Calendar.getInstance();
		 int month = cal.get(Calendar.MONTH);
		 String m = String.valueOf(month);
		 if (month < 10) {
				m = "0"+m;
		 }
		 int year = cal.get(Calendar.YEAR);
		 return year+""+m;
	}



	/**
	 *
	 * 功能描述:得到当前月份
	 * @param p_date
	 * @return
	 */
	public static int getMonthOfDate(Date p_date){
        Calendar c = Calendar.getInstance();
        c.setTime(p_date);
        return c.get(2) + 1;
    }

	/**
	 *
	 * 功能描述:得到日期
	 * @param p_date
	 * @return
	 */
	public static int getDayOfMonth(Date p_date){
        Calendar c = Calendar.getInstance();
        c.setTime(p_date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

	public static void main(String[] args ){
		//DateUtil a = new DateUtil();
		/* java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd");
		 Date first = getFirstday(new Date());
		 Date last = getLastday(new Date());
		System.out.println(sdf.format(new java.util.Date()));*/
		System.out.println(getCurrentMonday());

	}

	/**
	 * 主要是给jfinal使用，数据库只认java.sql.*
	 * @return
	 */
	public static Timestamp getSqlTimestamp(){
		return getSqlTimestamp(new Date().getTime());
	}

	/**
	 * 主要是给jfinal使用，数据库只认java.sql.*
	 * @param date
	 * @return
	 */
	public static Timestamp getSqlTimestamp(Date date){
		if(null == date){
			return getSqlTimestamp();
		}
		return getSqlTimestamp(date.getTime());
	}

	/**
	 * 主要是给jfinal使用，数据库只认java.sql.*
	 * @param time
	 * @return
	 */
	public static Timestamp getSqlTimestamp(long time){
		return new Timestamp(time);
	}

	/**
	 * 主要是给jfinal使用，数据库只认java.sql.*
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Timestamp getSqlTimestamp(String date, String pattern){
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return new Timestamp(format.parse(date).getTime());
		} catch (ParseException e) {
			return null;
		}
	}
	
}
