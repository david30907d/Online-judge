import java.io.*;
public class testfield
{
	public static int []input=new int[80];
	public static int []tree=new int[255];
	public static int n;
	public static void main(String args[])throws IOException
	{
		int m;
		String str1,str2;
		BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("建立二元樹：");
		System.out.print("欲輸入幾個數目：");
		str1=keyin.readLine();
		n=Integer.parseInt(str1);
		System.out.println("請輸入"+n+"個數：");
		for (m=0;m<n;m++)
		{
			str2=keyin.readLine();
			input[m]=Integer.parseInt(str2);//record the value i want to insert into this tree.
		} 
		bintree();
	}
	public static void bintree()
	{ 
		int maxnode,node=0,i,j;//maxnode means the max index of binary tree
		for (i=0;i<255;i++)
			tree[i]=0;//if this index of tree is not inserted, it'll maintain 0.
		tree[1]=input[0];//the first node must be input[0]
		maxnode=n;// i supposed maxnode is the amounts of input.
		for (i=1;i<n;i++)
		{
			node=1;//with every insertion, we must start from the first node to compare with every node to define whether it's greater or less than that node.
			while(tree[node]!=0)//if tree[node] is not 0, you should find another one till it's 0, then you can insert value into a null node.
			{
				if (input[i]<tree[node])
					node=2*node;//if the input value is less than node, it should be put on it's left side.
				else 
					node=2*node+1;
				if (maxnode<node)
				{
					maxnode=node;//refresh maxnode.				
				}
			}
			tree[node]=input[i];
		}	 
		System.out.println("循序陣列二元樹的內容：");
		for (j=1;j<=maxnode;j++)
			System.out.print(tree[j]+"   ");
		System.out.println();
	}
}
