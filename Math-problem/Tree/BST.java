import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;
public class Main{    
  public static String preorder=null;
  public static String inorder=null;
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner cin=new Scanner(System.in);     
    while(cin.hasNext()){         
      int time=cin.nextInt();
      for(int t=1;t<=time;++t){
        int input=cin.nextInt();
        int gap=child_gap(input);
        System.out.println((input-gap+1)+" "+(input+gap-1));//(gap-1)是input這個數字的左孩子的數量 同時也是幼孩子的數量，因為它是完滿二元數
  ，所以想要求極大及小直就要扣掉這個差距    }
    }
    cin.close();    
  }   
  public static int child_gap(int input){//會回傳跟min和max的差距
    return input & -input;
  }
}
