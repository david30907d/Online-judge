    import java.util.*;  
    public class Main {  
        public static char mazecell[][]=new char[22][22];  
        public static boolean trace[][]=new boolean[22][22];  
        public static void main(String[] args) {  
            // TODO Auto-generated method stub  
            Scanner cin=new Scanner(System.in);  
            int n=cin.nextInt();  
            for(int i=0;i<n;++i){  
                for(int j=0;j<n;j++){  
                    mazecell[i][j]=cin.next().charAt(0);  
                }  
            }  
            path(n-2,n-2);                
            for(int i=0;i<n;i++){  
                for(int j=0;j<n;j++){  
                    if(j==0){  
                        System.out.print(mazecell[i][j]);  
                    }  
                    else{  
                        System.out.print(" "+mazecell[i][j]);  
                    }  
                      
                }  
                System.out.println();  
            }  
        }     
        public static int path(int x,int y){  
            if(x==1&&y==1){  
                mazecell[x][y]='#';  
                return 1;  
            }  
            else if(mazecell[x][y]=='0'){//0是可以走的 1是牆壁
                mazecell[x][y]='#';//#是正確路徑
                if(path(x+1,y)+path(x-1,y)+path(x,y-1)+path(x,y+1)==0){  
                    mazecell[x][y]='0';//如果最後發現他是錯的再把它改回0          
                    return 0;  
                }  
                  
                else{                 
                    return 1;  
                }             
            }  
            else{  
                return 0;  
            }     
        }  
        
    }  
