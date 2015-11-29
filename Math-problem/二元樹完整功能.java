package binaryTree;
import java.util.InputMismatchException;
import static java.lang.System.out;
import java.util.Scanner;
class Student{
	int score;
	Student llink;
	Student rlink;
}
public class binaryTree {
	Student root,ptr;
	public static Scanner cin=new Scanner(System.in);
	public binaryTree(){
		root=null;
	}
	public void modify_f(){
		Student node;
		int search_s;		
		if(root==null){
			out.print("error, there is no data to modify");
		}		
		else{
			out.println("please input the score you want to search:");
			search_s=cin.nextInt();
			if((node=search(search_s))==null){
				out.print("error, cannot find this score!!");
			}
			else{
				out.println("enter new score");
				node.score=cin.nextInt();
				out.println("modify success");
			}
		}
		
	}
	public void insert_f(){
		int score=0;
		out.println("please input a int:");
		score=cin.nextInt();		
		access(score);
	}
	public void access(int score){
		Student node,pre=null;
		if(search(score)!=null){
			out.println("error!! cannot input same value");
			return;
		}
		ptr=new Student();
		ptr.score=score;
		ptr.rlink=null;
		ptr.llink=null;
		if(root==null){
			root=ptr;
		}
		else{
			node=root;
			while(node!=null){
				pre=node;
				if(score>node.score){
					node=node.rlink;
				}
				else{
					node=node.llink;
				}
			}
			if(score>pre.score){
				pre.rlink=ptr;
			}
			else{
				pre.llink=ptr;
			}
		}
	}
	public Student search(int score){
		Student node;
		node=root;
		while(node!=null){
			if(node.score==score){
				return node;
			}
			else{
				if(score>node.score){
					node=node.rlink;
				}
				else{
					node=node.llink;
				}
			}
		}
		return node;
	}
	public void delete_f(){
		int score;
		if(root==null){
			out.println("error!! there is no data to delete");
		}
		out.println("please input a data to delete");
		score=cin.nextInt();
		remove(score);
	}
	public void remove(int score){
		Student node;
		if((node=search(score))==null){
			out.println("error!! can't find "+score+" to delete");
		}
		if(node.llink!=null||node.rlink!=null){
			node=replace(node);
		}
		else{//左右都沒有小孩
			if(node==root){
				root=null;
			}
			else{
				connect(node,'n');
			}
		}
		node=null;//釋放記憶體
		out.println("score "+score+" has been removed successfully");
	}
	public Student replace(Student node){
		Student re_node;
		if((re_node=search_re_r(node.rlink))==null){
			re_node=search_re_l(node.llink);
		}
		if(re_node.rlink!=null){
			connect(re_node,'r');
		}
		else if(re_node.llink!=null){
			connect(re_node,'l');
		}
		else{
			connect(re_node,'n');
		}
		node.score=re_node.score;
		return re_node;
	}
	public Student search_re_r(Student node){
		Student re_node;
		re_node=node;
		while(re_node!=null&&re_node.llink!=null){
			re_node=re_node.llink;
		}
		return re_node;
	}
	public Student search_re_l(Student node){
		Student re_node;
		re_node=node;
		while(re_node!=null&&re_node.rlink!=null){
			re_node=re_node.rlink;
		}
		return re_node;
	}
	public void connect(Student node,char dir){
		Student parent=search_p(node);
		if(dir=='r'){
			parent.llink=node.rlink;
		}
		else if(dir=='l'){
			parent.rlink=node.llink;
		}
		else{
			if(parent.score>node.score){
				parent.llink=null;
			}
			else{
				parent.rlink=null;
			}		
		}		
	}
	public Student search_p(Student node){
		Student parent;
		parent = root;
		while(parent!=null){
			if(parent.score>node.score){
				if(parent.llink.score==node.score){
					return parent;
				}
				else{
					parent=parent.llink;
				}
			}
			else{
				if(parent.rlink.score==node.score){
					return parent;
				}
				else{
					parent=parent.rlink;
				}
			}
		}
		return parent;
	}
	public void show_f(){
		if(root==null){
			out.println("error, no data to show!!");
		}
		else{
			out.println("========DATA========");
			inorder(root);
		}
	}
	public void inorder(Student node){
		if(node!=null){
			inorder(node.llink);
			out.print(" "+node.score);
			inorder(node.rlink);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int option = 0;
		//Scanner cin = new Scanner(System.in);
		binaryTree obj = new binaryTree();		
		while(true)
		{
			System.out.println("");
			System.out.println("****************************");
			System.out.println("         <1> insert         ");
			System.out.println("         <2> delete         ");
			System.out.println("         <3> modify         ");
			System.out.println("         <4> show           ");
			System.out.println("         <5> quit           ");
			System.out.println("****************************");
			System.out.print("Enter your choice: ");
 	 	    try {
				option = cin.nextInt();
			} catch(InputMismatchException e) {
				cin.nextLine();
				System.out.printf("Not a correctly number.\n");
				System.out.printf("Try again\n\n");
			}
			switch(option)
			{
				case 1:
					obj.insert_f();
					break;
				case 2:
					obj.delete_f();
					break;
				case 3:
					obj.modify_f();
					break;
				case 4:
					obj.show_f();
					break;				
				default :
					System.out.println("Wrong option!");
			}
		}
		
	}

}
