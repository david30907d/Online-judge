import java.io.*;
public class Main
{
	public static int []a=new int[80];
	public static int []tree=new int[255];
	public static int n,s=0;
	public static void main(String args[])throws IOException
	{
		int m;
		String str1,str2;
		BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("二元樹的中序追蹤：");
		System.out.print("欲輸入幾個數目：");
		str1=keyin.readLine();
		n=Integer.parseInt(str1);
		System.out.println("請輸入"+n+"個數：");
		for (m=0;m<n;m++)
		{
			str2=keyin.readLine();
			a[m]=Integer.parseInt(str2);
		} 
		maketree();
		System.out.println("二元樹中序追蹤的結果：");
		inorder(1);
	}
	public static void maketree()
	{ 
		int node=1,i,j,temp;
		for (i=0;i<255;i++)
			tree[i]=0;
		for (i=0;i<n;i++)
		{
			tree[node]=a[i];
			node++;
		}	 
		System.out.println("二元樹的內容：");
		for (j=1;j<=n;j++)
			System.out.print(tree[j]+"   ");
		System.out.println();
	}
	public static void inorder(int node)	
	{
	//use recursive, if the tree[node] is not 0, it will traverse through the tree until it find a 0 node, then it will print it parent node which must not be 0, and so on.
		if (tree[node]!=0)		
		{
			inorder(2*node);
			//print left node first
			if (tree[node]!=0)
				System.out.print(tree[node]+"  ");
			//print middle node second
			inorder(2*node+1);
			//print right node last.
		}
	}
}
