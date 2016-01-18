import java.util.*;  
public class Main {  
    public static char mazecell[][]=new char[22][22];  
    public static boolean visit[][]=new boolean[22][22];  
    public static int sizex, sizey;
    public static int count=0;
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Scanner cin=new Scanner(System.in);  
        while(cin.hasNext()){
        	init();

        	sizey=cin.nextInt();  
        	sizex=cin.nextInt();
        	if(sizex==0){//end
        		break;
        	}
        	int manx=0,many=0;
        	count=0;
        	cin.nextLine();//to eat the \n at the first line.
        	for(int i=0;i<sizex;++i){  
        		String input=cin.nextLine();
        	    for(int j=0;j<sizey;j++){  
        	        mazecell[i][j]=input.charAt(j);  
        	        if(mazecell[i][j]=='@'){
        	        	manx=i;many=j;//manx many是人的初始位置
        	        }
        	    }  
        	}  
        	    
        	path(manx,many);        	
        	System.out.println(count);
        }
        
    }     
    public static void path(int x,int y){      	   	        
        if(y<0 || y>=sizey || x<0||x>=sizex|| mazecell[x][y]=='#' || visit[x][y]==true){  // these case are not allowed, so return.
            return;  
        }  

        //these are allowed, so make it visited and count++.
        visit[x][y]=true;
        count++;            
        path(x-1,y);
        path(x+1,y);
        path(x,y+1);
        path(x,y-1);                   
            
    } 
    public static void init(){
    	for(int i=0;i<=20;++i){
    		for(int j=0;j<=20;++j){
    			visit[i][j]=false;
    		}
    	}
    }
}  