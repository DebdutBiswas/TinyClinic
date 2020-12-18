package sCMS.common;

import java.util.Date;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.Instant;

public class Util {
	public static final Date epochDate = Date.from(Instant.EPOCH);
	@SuppressWarnings("serial")
	public static final Map<String, Integer> weekDaysMap = new HashMap<String, Integer>() {{
		put("Su", 1); put("Mo", 2); put("Tu", 3); put("We", 4); put("Th", 5); put("Fr", 6); put("Sa", 7);
	}};
	
	/* Date Related Utility Methods */
	public static Date stringDateFormatToDate(String stringDate) throws ParseException {
		return new SimpleDateFormat("dd-MM-yyyy").parse(stringDate);
	}
	
	public static Date stringDateFormatToDate(String stringDate, String dateFormat) throws ParseException {
		return new SimpleDateFormat(dateFormat).parse(stringDate);
	}
	
	public static String dateToStringDateFormat(Date objDate, String dateFormat) {
		return new SimpleDateFormat(dateFormat).format(objDate);
	}
	
	public static Map<String, Date> daysOfWeekToDates(String[] daysOfWeek) {
		Map<String, Date> daysOfWeekToDatesMap = new HashMap<String, Date>();
		Calendar currentDateInCalendar = Calendar.getInstance();
		for (String dayOfWeek : daysOfWeek) {
			currentDateInCalendar.setTime(new Date());
			for (int weekDay = 1; weekDay <= weekDaysMap.size(); weekDay++) {
				if (weekDaysMap.get(dayOfWeek) == currentDateInCalendar.get(Calendar.DAY_OF_WEEK)) {
					daysOfWeekToDatesMap.put(dayOfWeek, currentDateInCalendar.getTime());
					break;
				}
				currentDateInCalendar.add(Calendar.DATE, 1);
			}
		}
		
		return daysOfWeekToDatesMap;
	}
	
	public static Map<String, Date> daysOfWeekToDates(String[] daysOfWeek, Date startingObjDate) {
		Map<String, Date> daysOfWeekToDatesMap = new HashMap<String, Date>();
		Calendar currentDateInCalendar = Calendar.getInstance();
		for (String dayOfWeek : daysOfWeek) {
			currentDateInCalendar.setTime(startingObjDate);
			for (int weekDay = 1; weekDay <= weekDaysMap.size(); weekDay++) {
				if (weekDaysMap.get(dayOfWeek) == currentDateInCalendar.get(Calendar.DAY_OF_WEEK)) {
					daysOfWeekToDatesMap.put(dayOfWeek, currentDateInCalendar.getTime());
					break;
				}
				currentDateInCalendar.add(Calendar.DATE, 1);
			}
		}
		
		return daysOfWeekToDatesMap;
	}
	
	public static Map<String, Date> daysOfWeekToDates(String[] daysOfWeek, String startingStringDate) throws ParseException {
		Map<String, Date> daysOfWeekToDatesMap = new HashMap<String, Date>();
		Calendar currentDateInCalendar = Calendar.getInstance();
		for (String dayOfWeek : daysOfWeek) {
			currentDateInCalendar.setTime(stringDateFormatToDate(startingStringDate));
			for (int weekDay = 1; weekDay <= weekDaysMap.size(); weekDay++) {
				if (weekDaysMap.get(dayOfWeek) == currentDateInCalendar.get(Calendar.DAY_OF_WEEK)) {
					daysOfWeekToDatesMap.put(dayOfWeek, currentDateInCalendar.getTime());
					break;
				}
				currentDateInCalendar.add(Calendar.DATE, 1);
			}
		}
		
		return daysOfWeekToDatesMap;
	}
	/* Date Related Utility Methods End */
	
	/* Debug & Test Class Methods */
	/*
	public static void main(String[] args) throws ParseException {
		String[] visitDays = {"We", "Fr", "Su"};
		
		Map<String, Date> dofMp0 = new HashMap<String, Date>();
		dofMp0 = daysOfWeekToDates(visitDays);
		
		Map<String, Date> dofMp1 = new HashMap<String, Date>();
		dofMp1 = daysOfWeekToDates(visitDays, stringDateFormatToDate("28-08-2020"));
		
		Map<String, Date> dofMp2 = new HashMap<String, Date>();
		dofMp2 = daysOfWeekToDates(visitDays, "25-08-2020");
		
		for (String dof0 : dofMp0.keySet()) {
			System.out.println(dof0 + dateToStringDateFormat(dofMp0.get(dof0), " - EEE (dd-MM-yyyy)"));
		}
		
		System.out.println("----------------");
		
		for (String dof1 : dofMp1.keySet()) {
			System.out.println(dof1 + dateToStringDateFormat(dofMp1.get(dof1), " - EEE (dd-MM-yyyy)"));
		}
		
		System.out.println("----------------");
		
		for (String dof2 : dofMp2.keySet()) {
			System.out.println(dof2 + dateToStringDateFormat(dofMp2.get(dof2), " - EEE (dd-MM-yyyy)"));
		}
	}
	*/
	/* Debug & Test Class Methods End */
}