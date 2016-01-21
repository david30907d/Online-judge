import java.util.ArrayList;
import java.util.Scanner;
public class Main{		
	public static ArrayList<Integer>[] tree=new ArrayList[10000+5];
	public static int[] parent=new int[10005];	
	public static int[] depth=new int[10005];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);			
		int time=0;	
		for(int i=0;i<10000+2;++i){	
			tree[i]=new ArrayList<Integer>();
			parent[i]=-1;//those node without parent like root, assign -1 to it.
		}//initialization
		
		while(cin.hasNext()){					
			time=cin.nextInt();
			for(int count=1;count<=time;++count){	
				for(int i=0;i<10000+2;++i){	
					parent[i]=-1;//those node without parent like root, assign -1 to it.
				}//initialization							
				int len=cin.nextInt();
				for(int i=0;i<len-1;++i){
					int an=cin.nextInt();
					int chi=cin.nextInt();
					tree[an].add(chi);
					parent[chi]=an;
				}

				int root_index=0;
				for(int i=1;parent[i]>=0;++i){
					root_index=i;//值為-1的就是根
				}
				give_depth(++root_index,1);
				// for(int i=1;i<=len;++i){
				// 	System.out.print(depth[i]+" ");
				// }
				// System.out.println();
				// for(int i=1;i<=len;++i){
				// 	System.out.print(parent[i]+" ");
				// }
				// System.out.println();
				int x=cin.nextInt();
				int y=cin.nextInt();
				while(x!=y){
					//System.out.println(depth[x]+" "+depth[y]);
					if(depth[x]>depth[y]){
						x=parent[x];
					}
					else{
						y=parent[y];
					}
				}
				System.out.println(x);
				
				for(int i=0;i<=len;++i){
					tree[i].clear();
				}
			}
		}
		cin.close();		
	}	
	public static void give_depth(int node_index, int dep){
		depth[node_index]=dep;		
		//Iterator<Integer> iter = tree.len();		
		for(int i=0;i<tree[node_index].size();++i){
			give_depth(tree[node_index].get(i), dep+1);
		}
	}
}
