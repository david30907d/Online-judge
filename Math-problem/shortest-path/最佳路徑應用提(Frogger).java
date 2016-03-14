import java.util.*;                           //导入java 下的工具包
import java.math.*;

public class Main {                          //建立一个公共的Main类
	public static void main(String[] args){ //定义main函数的参数是一个字串类型的数组args
		Scanner input = new Scanner(System.in); //定义java的标准输入
		int N,testcase = 0;                        //石头数为0，测试用例编号初始化
		boolean[][] con=new boolean[1<<9][1<<9];  // 在边长不超过当前上限的情况下，i节点可达j节点的标志为con[i][j]
		double[][] L = new double[1<<9][1<<9];    //（i，j）的边长为dis[i][j]
		while ((N=input.nextInt())!=0){             //反复输入石头数n
			double[] x = new double [N];           //为石头的坐标序列申请内存
			double[] y = new double [N];
			for (int i=0;i<N;i++){                 //输入每块石头的坐标
				x[i] = input.nextDouble();
				y[i] = input.nextDouble();
			}
			double l = 0,r = 1e5;                 //区间的左右指针初始化
			for (int i=0;i<N;i++)                 //计算边长矩阵L
				for (int j=0;j<N;j++)
					L[i][j] = Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
			while (r-l>=1e-5){
			  double mid = (l+r)/2; // 计算区间的中间点
			  for (int i=0;i<N;i++) //计算con[i][j]= 
			   for (int j=0;j<N;j++)
				 if (L[i][j]>mid) con[i][j] = false;
			     else con[i][j] = true;
		      for (int k=0;k<N;k++)//在边长不超过mid的情况下计算可达的节点对标志con
			   for (int i=0;i<N;i++)
			     for (int j=0;j<N;j++)
				   con[i][j] |= con[i][k]&con[k][j];
		      if (con[0][1]) r = mid;  
		      //若节点0至节点1的边长不超过mid，则最长边的最小值在左区间；否则在右区间
			  else l = mid;
			}
		  System.out.println("Scenario #"+(++testcase));  //输出测试用例编号和最短边长
		  System.out.println("Frog Distance="+ BigDecimal.valueOf(l).setScale(3,RoundingMode.HALF_UP));
		  System.out.println("");
		}
	}

}
