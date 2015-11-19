import java.io.*;
public class ko5_6
{
	public static int []a=new int[80];
	public static int []tree=new int[255];
	public static int n,k,maxnode;
	public static void main(String args[])throws IOException
	{
		int m;
		String str1,str2;
		BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("建立二元搜尋樹：");
		System.out.print("欲輸入幾個數目：");
		str1=keyin.readLine();
		n=Integer.parseInt(str1);
		System.out.println("請輸入"+n+"個數：");
		for (m=0;m<n;m++)
		{
			str2=keyin.readLine();
			a[m]=Integer.parseInt(str2);
		} 
		System.out.print("輸入欲插入的數值：");
		str1=keyin.readLine();
		k=Integer.parseInt(str1);
		bintree();
		insert_node();
	}
	public static void bintree()
	{ 
		int s=0,node=0,i,j;
		for (i=0;i<255;i++)
			tree[i]=0;
		tree[1]=a[0];
		maxnode=n;
		for (i=1;i<n;i++)
		{
			node=1;
			while(tree[node]!=0)
			{
				if (a[i]<tree[node])
					node=2*node;
				else 
					node=2*node+1;
				if (maxnode<node)
				{
					maxnode=node;					
				}
			}			
			tree[node]=a[i];
		}	 
		System.out.println("二元搜尋樹的內容：");
		for (j=1;j<=maxnode;j++)
			System.out.print(tree[j]+"   ");
		System.out.println();
	}
	public static void insert_node()
	{
		int p,s=1,node=1;
		while(tree[node]!=0)
		{
			if (k<tree[node])
				node=2*node;
			else
				node=2*node+1;
			if (maxnode<node)
			{				
				maxnode=node;//use maxnode to record the amount of total nodes. This value is used to traversed through the whole tree.
			}
		}
		tree[node]=k;
		System.out.println("顯示插入"+k+"二元搜尋樹的結果:");
		while(s<=maxnode)
		{
			System.out.print(tree[s]+"   ");
			s++;
		}
	}
}
