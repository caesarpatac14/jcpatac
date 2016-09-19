/**
*
* Created by jcpatac on 9/16/16.
*
**/

public class Date {
	private int day;
	private int month;
	private int year;

	public Date() {
		this.day = 1;
		this.month = 1;
		this.year = 1000;
	}

	public Date(int year, int month, int day) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public void setDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setDay(int day) {
		if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day > 0 && day <= 31)) {
			this.day = day;
		}else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day > 0 && day <= 30)) {
			this.day = day;
		}else if ((month == 2) && (day > 0 && day <= 29)) {
			if ((year % 100 == 0 && year % 400 == 0) && (day > 0 && day <= 29)) {
				this.day = day;
			}else if ((year % 100 == 0 && year % 400 != 0) && (day > 0 && day <= 28)) {
				this.day = day;
			}else {
				throw new IllegalArgumentException("Invalid day!");
			}
		}else {
			throw new IllegalArgumentException("Invalid date!");
		}
	}

	public void setMonth(int month) {
		if (month > 0 && month <= 12) {
			this.month = month;
		}else {
			throw new IllegalArgumentException("Invalid Month!");
		}
	}

	public void setYear(int year) {
		if (year >= 1000 && year <= 9999) {
			this.year = year;
		}else {
			throw new IllegalArgumentException("Invalid Year!");
		}
	}

	public String toString() {
		String day = String.format("%02d", this.day);
		String month = String.format("%02d", this.month);
		String year = String.format("%02d", this.year);
		String date = day + "/" + month + "/" + year;
		return date;
	}
}

/**
*
* There are two ways to write error-free programs; only the third one works. – Alan J. Perlis
*
**/
