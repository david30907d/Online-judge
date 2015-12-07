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
            checkroad(1,1);  
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
            else if(mazecell[x][y]=='0'){  
                mazecell[x][y]='#';  
                if(path(x+1,y)+path(x-1,y)+path(x,y-1)+path(x,y+1)==0){  
                    mazecell[x][y]='*';  
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
        public static void checkroad(int i,int j){        
            trace[i][j]=true;  
            if(mazecell[i-1][j]=='*'){  
                if(mazecell[i+1][j]=='#'){  
                    eliroad(i-1,j);  
                }  
            }  
            if(mazecell[i][j-1]=='*'){  
                if(mazecell[i-1][j]=='#'||mazecell[i+1][j]=='#'){  
                    eliroad(i,j-1);  
                }  
            }  
            if(mazecell[i][j+1]=='*'){            
                if(mazecell[i-1][j]=='#'||mazecell[i+1][j]=='#'||mazecell[i][j-1]=='#'){  
                    eliroad(i,j+1);  
                }  
            }  
              
              
            if(mazecell[i][j-1]=='0'){  
                if(mazecell[i][j+1]=='#'&&trace[i][j+1]==false){  
                    restroad(i,j-1);  
                }  
            }  
            if(mazecell[i-1][j]=='0'){  
                if(mazecell[i][j-1]=='#'&&trace[i][j-1]==false||mazecell[i][j+1]=='#'&&trace[i][j+1]==false){  
                    restroad(i-1,j);  
                }  
            }  
            if(mazecell[i+1][j]=='0'){            
                if(mazecell[i-1][j]=='#'&&trace[i-1][j]==false||mazecell[i][j-1]=='#'&&trace[i][j-1]==false||mazecell[i][j+1]=='#'&&trace[i][j+1]==false){  
                    restroad(i+1,j);  
                }  
            }  
              
              
            if(mazecell[i-1][j]=='#'&&trace[i-1][j]==false){  
                checkroad(i-1,j);             
            }  
            else if(mazecell[i+1][j]=='#'&&trace[i+1][j]==false){  
                checkroad(i+1,j);  
            }         
            else if(mazecell[i][j-1]=='#'&&trace[i][j-1]==false){  
                checkroad(i,j-1);  
            }  
            else if(mazecell[i][j+1]=='#'&&trace[i][j+1]==false){  
                checkroad(i,j+1);  
            }  
        }  
        public static void eliroad(int i,int j){          
            trace[i][j]=true;  
            mazecell[i][j]='0';  
            if(mazecell[i-1][j]=='*'&&trace[i-1][j]==false){  
                eliroad(i-1,j);           
            }  
            if(mazecell[i+1][j]=='*'&&trace[i+1][j]==false){  
                eliroad(i+1,j);  
            }         
            if(mazecell[i][j-1]=='*'&&trace[i][j-1]==false){  
                eliroad(i,j-1);  
            }  
            if(mazecell[i][j+1]=='*'&&trace[i][j+1]==false){  
                eliroad(i,j+1);  
            }  
        }  
        public static void restroad(int i,int j){  
            trace[i][j]=false;  
            mazecell[i][j]='*';  
            if(mazecell[i-1][j]=='0'&&trace[i-1][j]==true){  
                restroad(i-1,j);              
            }  
            if(mazecell[i+1][j]=='0'&&trace[i+1][j]==true){  
                restroad(i+1,j);  
            }         
            if(mazecell[i][j-1]=='0'&&trace[i][j-1]==true){  
                restroad(i,j-1);  
            }  
            if(mazecell[i][j+1]=='0'&&trace[i][j+1]==true){  
                restroad(i,j+1);  
            }  
        }  
    }  
