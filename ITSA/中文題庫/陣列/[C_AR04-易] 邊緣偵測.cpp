#include <iostream>
using namespace std;
int main(int argc, char** argv) {
	int num=0;
	while((cin>>num)!=0){ 
		for(int i=1;i<=num;i++){//會重複做NUM次，也就是NUM個圖形
			int row=0,column=0;
			cin >>row>>column;
			
			int graph[row][column];//宣告陣列
			for(int j=0;j<=row-1;j++){
				for(int k=0;k<=column-1;k++){
					cin>>graph[j][k];
				}
			}//到此陣列都書玩了 
			for(int l=0;l<=row-1;l++){
				for(int m=0;m<=column-1;m++){
						if(graph[l][m]==0){
							cout<<"_ ";
							
						}
						else{
							if(l>0&&graph[l-1][m]==0){
								cout<<"0 ";
					
							}	
							else if(l<row-1&&graph[l+1][m]==0){
								cout<<"0 ";
							}
							else if(m>0&&graph[l][m-1]==0){
								cout<<"0 ";
							}
							else if(m<column-1&&graph[l][m+1]==0){
								cout<<"0 "; 
							}
							else {
								cout<<"_ ";
								
							}
						} 
				}
				cout <<"\n";
			}
			if(i!=num){
				cout<<"\n";
			}
		}//輸出的for loop
	}
	return 0;
}	
	


