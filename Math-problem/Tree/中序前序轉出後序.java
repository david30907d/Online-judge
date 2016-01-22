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
      preorder=cin.next();
      inorder=cin.next();
      convert(0,preorder.length()-1,0,inorder.length()-1);
      System.out.println();
    }
    cin.close();    
  }   
  public static void convert(int prel, int prer, int inl, int inr){
    int root=0;
    for(root=inl;root<=inr;root++){
      if(preorder.charAt(prel) == inorder.charAt(root)) break;//這樣我就找到前序是的root了，當這段字串只剩一個的時候，prel就會是root而且他就是樹葉，這個時候地回就不會再繼續了，並且會在下面被印出來
    }

    int leftsize=root-inl;
    int rightsize=inr-root;
    if(leftsize>0){//只要左子樹的長度不唯一，就代表他還不是樹葉，所以要繼續遞回
      convert(prel+1,prel+leftsize,inl,root-1);
    }
    if(rightsize>0){
      convert(prel+leftsize+1,prer,root+1,inr);
    }
    System.out.print(inorder.charAt(root));
  }
}
