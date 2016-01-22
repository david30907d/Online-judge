import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;
public class Main{    
  public static int origin_depth,after_depth2;
  public static int i;
  public static String input;
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner cin=new Scanner(System.in);     
    int time=1;
    while(cin.hasNext()){         
      input=cin.nextLine();
      if (input.charAt(0)=='#') {
        break;
      }
      i=origin_depth=after_depth2=0;//initialization.
      convert(0,0);
      System.out.println("Tree "+(time++)+": "+origin_depth+" => "+after_depth2);
    }
    cin.close();    
  }   
  public static void convert(int ori_d, int atf_d){
    int child=0;
    while(input.charAt(i)=='d'){
      child++;
      i++;
      convert(ori_d+1, atf_d+child);
    }    
    i++;
    if(i>=input.length()) i--;//如果他已經到達自串的長度 就不能再++
    origin_depth=ori_d>origin_depth?ori_d:origin_depth;
    after_depth2=atf_d>after_depth2?atf_d:after_depth2; 
  }
}
