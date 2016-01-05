// 圖形的追蹤: 利用相鄰串列與蹤向優先搜尋演算法(dfs)
// File name: G_dfs.java
// Version 1.0, 5-25-2008

import java.io.*;
import java.util.Scanner;
class Node
{
	int vertex;
	Node link;
}

public class dfs
{
	final static int MAX_V=100; /*最大節點數*/
	Node node = new Node();
	Node lastnode = new Node();
	static Node[] adjlist = new Node[MAX_V+1];        // 宣告相鄰串列
	static boolean[] visited = new boolean[MAX_V+1];  // 記錄頂點是否已拜訪
	static int total_vertex=0;
 
	public void build_adjlist()
	{   
		Scanner cin=new Scanner(System.in);
		total_vertex=cin.nextInt();
		for ( int vi = 1; vi <= total_vertex; vi++) {
			// 設定陣列及各串列啟始值
			visited[vi] = false;
			adjlist[vi] = new Node();
			adjlist[vi].vertex = vi ;
			adjlist[vi].link = null;
		}
		
		// 讀取節點資料
		for (int vi = 1; vi <= total_vertex; vi++ )
			for (int vj = 1; vj <= total_vertex; vj++ ) {
				// 資料檔以相鄰矩陣格式儲存,以1代表相鄰
				// 0 代表不相鄰，將相鄰頂點鏈結在各串列後
 
				int weight = cin.nextInt();
 
				if ( weight != 0 ) {
					node = new Node();
					node.vertex = vj;
					node.link = null;
					lastnode = searchlast(adjlist[vi]);
					lastnode.link = node;
				}
			} 
			cin.close(); 
	}

	// 顯示各相鄰串列之資料
	public void show_adjlist()
	{
		int index=0;
		Node ptr = new Node();

		System.out.print("Head    adjacency nodes\n");
		System.out.print("------------------------------\n");
		for (index = 1; index <= total_vertex; index++) {
			System.out.print("V" + adjlist[index].vertex + " ");
			ptr = adjlist[index].link;
			while ( ptr != null ) {
				System.out.print("--> V" + ptr.vertex + " ");
				ptr = ptr.link;
			}
			System.out.print("\n");
		}
	}

	// 圖形之蹤向優先搜尋
	public void dfs(int v)
	{
		Node ptr = new Node();
		int w=0;

		System.out.print("V" + adjlist[v].vertex + " ");
		visited[v] = true;          // 設定v頂點為已拜訪過
		ptr = adjlist[v].link;      /* 拜訪相鄰頂點*/

		do {
			/* 若頂點尚未走訪，則以此頂點為新啟始點繼續
			 做蹤向優先搜尋法走訪，否則找與其相鄰的頂點
			 直到所有相連接的節點都已走訪*/
			w = ptr.vertex;
			if ( visited[w] == false)
				dfs(w);
			else
				ptr = ptr.link;
		} while ( ptr != null);
	}

	public Node searchlast( Node linklist )
	{
		Node ptr = new Node();

		ptr = linklist;
		while ( ptr.link != null ) 
			ptr = ptr.link;
		return ptr;
	}
	
	public static void main(String args[])  // 主函數		 
	{
		dfs obj = new dfs();
 
		obj.build_adjlist(); // 以相鄰串列表示圖形
		obj.show_adjlist();  // 顯示串列之資料
		System.out.print("\n------Depth First Search------\n");
		obj.dfs(1);          // 圖形之蹤向優先搜尋，以頂點1為啟始頂點
	}
}
