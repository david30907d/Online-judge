import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main{
	public static int[] arr = new int[20];
	public static String[] week_str = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
	public static int[] month_arr={0,31,28,31,30,31,30,31,31,30,31,30,31};
	public static boolean isleap=false;//leap is 閏年
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);				
		while(cin.hasNext()){
			int year=2000, month=1, day=1;//initialization
			String strmonth="",strday = "";
			day=cin.nextInt();
			if(day == -1) break;// the end.
			String week= week_str[day%7];
			

			while(day>=dayofyear(year)){
				day-=dayofyear(year);
				year++;
			}

			while(day>=dayofmonth(month,isleap)){
				day-=dayofmonth(month,isleap);
				month++;
			}

			day++;//因為我們輸入的day是指離2000/01/01幾天後的天數
			//所以現在要把一開始的一加回來才是真正的日期
			if(month<10){
				strmonth="0"+Integer.toString(month);
			}
			else{
				strmonth=Integer.toString(month);
			}

			if(day<10){
				strday="0"+Integer.toString(day);
			}
			else{
				strday=Integer.toString(day);
			}
			
			System.out.println(year+"-"+strmonth+"-"+ strday+" "+week);
		}
		cin.close();
	}	
	public static int dayofyear(int y){
		if (((y%4==0) && (y%100!=0)) || (y%400==0)){
			isleap=true;//is leap,閏年
			return 366;
		}
	    else{
	    	isleap=false;
	    	return 365;
	    }
	}
	public static int dayofmonth(int m, boolean isleap){
		if(isleap && m==2) return 29;
		else{
			return month_arr[m];
		}
	}
}
