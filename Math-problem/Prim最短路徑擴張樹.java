import java.io.*;
public class testfield
{
	public static int [][]cost=new int[20][20];
	public static int n,k,m,start;
	public static int trace[]=new int[20];
	public static int available_road_and_its_mincost[]=new int[20];//因為這是Prim法，
	//所以他需要去記現在有哪些路徑是可以走的,而且只記到達那個點是花費最少的金錢數，這樣就可以避免出現迴圈
	public static int from_which_position[]=new int[20];
	public static void main(String args[])throws IOException
	{
		int p,x,y,t,temp=1;
		String str1,str2,str3,str4,str5,str6;
		BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("這是Prim法！！");
		System.out.println("花費最小擴張樹:");
		System.out.print("輸入頂點總數:");
		str1=keyin.readLine();
		n=Integer.parseInt(str1);
		System.out.print("輸入邊的數目:");
		str2=keyin.readLine();
		p=Integer.parseInt(str2);
		System.out.println("請輸入"+p+"個邊的頂點:");
		for (k=1;k<20;k++)
		{
			trace[k]=0;
			available_road_and_its_mincost[k]=0;
			from_which_position[k]=0;
		}
		for (k=1;k<=n;k++)
			for (m=1;m<=n;m++)
				cost[k][m]=0;
			while(p>=temp)
			{ 
				System.out.print("從頂點:");
				str3=keyin.readLine();
				x=Integer.parseInt(str3);
				System.out.print("到頂點:");
				str4=keyin.readLine();
				y=Integer.parseInt(str4);
				System.out.print("輸入加權數:");
				str5=keyin.readLine();
				t=Integer.parseInt(str5);
				cost[x][y]=t;
				cost[y][x]=t;
				temp++;
			}  
			display();
			System.out.print("輸入起始位址：");
			str6=keyin.readLine();
			start=Integer.parseInt(str6);
			int total_cost=mst();
			System.out.println("the min cost is "+total_cost);
		}
		public static void display()
		{
			System.out.println("相鄰陣列為:");
			for (k=1;k<=n;k++)
			{
				for (m=1;m<=n;m++)
					System.out.print(cost[k][m]+"  ");
				System.out.println();
			}
		}
		public static int mst()
		{
			int j,i,temp_next_start_position=0,temp,sum=0;
			System.out.println("花費最小擴張樹的結果:");
			for (j=1;j<n;j++){//n is the number of vertices, so we need to do n-1 times.
				//因為n個頂點就只有n-1個邊，所以只要做到n-1次
				temp=2147483647;//temp is just a max value, to make every cost less than temp can be recorded in temp.
				trace[start]=-1;//is this veritece has been reached, then its value is -1.
				for (i=1;i<=n;i++){//cause every row has n elements, though one of it is itself, but still compare with all of it.
					if (cost[start][i]!=0 && trace[i]==0 && available_road_and_its_mincost[i]==0)
					{
						available_road_and_its_mincost[i]=cost[start][i];
						from_which_position[i]=start;//
					}
					else if (cost[start][i]!=0 && trace[i]==0  &&cost[start][i]<available_road_and_its_mincost[i] && available_road_and_its_mincost[i]!=0)
						//這個條件會發生再當你發現有可以花更少的前也可以到達相同的點的時候，就會把舊的金錢給取代掉
						//這樣永遠只會楚存一種到達該點的方法，就不會出現回圈了
					{
						available_road_and_its_mincost[i]=cost[start][i];
						from_which_position[i]=start;
					}
					if (available_road_and_its_mincost[i]!=0 && available_road_and_its_mincost[i]<temp && trace[i]==0)
					{
						temp=available_road_and_its_mincost[i];
						temp_next_start_position=i;//temp_next_start_position is the index that will start in the next interation.
					}
				}
				start=temp_next_start_position;//確定下一次要從temp_next_start開始走
				sum+=available_road_and_its_mincost[start];
				available_road_and_its_mincost[start]=0;//cause this vertix has been reached, so it's not available now. If you didn't turn it to 0, you will make a circle for your path, which will be disastrous				
				System.out.println(from_which_position[start]+"-"+start);//把到start(其實就是temp_next_start)這個點的數字也一起印出來
			}
			return sum;
		}
}
