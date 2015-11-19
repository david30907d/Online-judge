// 將數學式子由中序表示法轉為後序表示法
// File name: infixToPostfix.java
// Version 1.0, 5-25-2008

import java.io.*;
import java.lang.String;
import java.util.Scanner;

class infixToPostfix
{
	static int MAX=20;
	static char infix_q[] = new char[MAX];
	static Scanner keyboard = new Scanner(System.in);
	
 	infixToPostfix() 
	{
		int i;
		for (i=0; i<MAX; i++)
			infix_q[i]='\0';
	}    

	public static void infix_to_postfix() throws IOException
	{
		int rear=0, top=0, ctr=0, i=0, index=-1;
		char stack_t[] = new char[MAX];   // 用以儲存還不必輸出的運算子
 
		for (i=0; i<MAX; i++){
			stack_t[i]='\0';
 		}
		
		System.out.print("請輸入一中序運算式: ");
		String str = keyboard.next();  
  
	    i=0;
		while (i < str.length()) {	
			index++;	 
			infix_q[index]=str.charAt(index);
 			i++;
 		}
 
 		infix_q[index+1] = '#';  // 於佇列結束時加入#為結束符號
  		
		System.out.print("Postfix expression: ");
		stack_t[top]  = '#';    // 於堆疊最底下加入#為結束符號
  
		for (ctr = 0; ctr <= index+1; ctr++) {	
 	 		switch (infix_q[ctr]) {
				// 輸入為)，則輸出堆疊內運算子，直到堆疊內為(
				case ')':
					while(stack_t[top]!='(') 			      
						System.out.printf("%c", stack_t[top--]);				   
					top--;
					break;					
					
				// 輸入為#，則將堆疊內還未輸出的運算子輸出
				case '#':
					while(stack_t[top]!='#')
						System.out.printf("%c", stack_t[top--]);
					break;
 					
				// 輸入為運算子，若小於TOP在堆疊中所指運算子，則將堆疊所指運算子輸出
				// 若大於等於TOP在堆疊中所指運算子，則將輸入之運算子放入堆疊
				case '(':
				case '^':
				case '*':
				case '/':
				case '+':
				case '-': 	
 				    while (compare(stack_t[top], infix_q[ctr])==1)
						System.out.printf("%c", stack_t[top--]);
					stack_t[++top] = infix_q[ctr];
					break;	
						
				// 輸入為運算元，則直接輸出
				default :
					System.out.printf("%c", infix_q[ctr]);
			}
		}
	}

	// 比較兩運算子優先權，若輸入運算子小於堆疊中運算子，則傳回值為1，否則為0
	public static int compare(char stack_o, char infix_o)
	{
		// 在中序表示法佇列及暫存堆疊中，運算子的優先順序表，其優先權值為INDEX/2
		char[] infix_priority = new char[9] ; 
		char[] stack_priority = new char[8] ;
		int index_s=0, index_i=0;

		infix_priority[0]='#';infix_priority[1]=')';
		infix_priority[2]='+';infix_priority[3]='-';
		infix_priority[4]='*';infix_priority[5]='/';
		infix_priority[6]='^';infix_priority[7]=' ';
		infix_priority[8]='(';      

		stack_priority[0]='#';stack_priority[1]='(';
		stack_priority[2]='+';stack_priority[3]='-';
		stack_priority[4]='*';stack_priority[5]='/';
		stack_priority[6]='^';stack_priority[7]=' ';

		while (stack_priority[index_s] != stack_o)
			index_s++;
		while (infix_priority[index_i] != infix_o)
			index_i++;
 
		return ((int)(index_s/2) >= (int)(index_i/2) ? 1 : 0);
	}
   
	public static void main (String args[])throws IOException //主函數		
	{ 
		infixToPostfix obj = new infixToPostfix();

		System.out.print("\n*********************************\n");
		System.out.print("      -- 有效運算子 --\n");
		System.out.print(" ^: 次方\n");
		System.out.print(" *: 乘      /: 除\n");
		System.out.print(" +: 加      -: 減\n");
		System.out.print(" (: 左括號  ): 右括號\n");
		System.out.print("*********************************\n");

		obj.infix_to_postfix();	
	}
}
