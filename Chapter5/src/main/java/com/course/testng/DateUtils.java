package com.course.testng;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description: java类作用描述
 * @Author: zhangxiaochen
 * @CreateDate: 2018/7/12 16:40
 */
public class DateUtils {
    public static void main(String[] args) {
        handleCirculationDate("2018-07-12", "2018-07-13");
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,30);//把日期往后增加一天.整数往后推,负数往前移动
        Date date1 =calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);

        System.out.println(findDates(new Date(), date1));

    }

    public static List<Date> findDates(Date dBegin, Date dEnd) {
        List<Date> lDate = new ArrayList<Date>();
        lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime()))  {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }
        return lDate;
    }

    public static List<String> handleCirculationDate(String today, String passday) {
        List<String> listDate = new ArrayList<String>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateFormat.parse(passday);
            Date endDate = dateFormat.parse(today);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            while (calendar.getTime().before(endDate)){
                System.out.println(dateFormat.format(calendar.getTime()));
                listDate.add(dateFormat.format(calendar.getTime()));
                calendar.add(Calendar.DAY_OF_MONTH,1);
            }
            return listDate;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
