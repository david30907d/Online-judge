+#include<iostream>
+using namespace std;
+
+bool sudoku_check(int *p){
+  bool b1[9];
+  for(int i=0;i<9;i++)b1[i]=0;
+  //for(int i=0;i<9;i++)cout<<p[i]<<" ";cout<<endl;
+  for(int i=0;i<9;i++)b1[p[i]-1]=1;
+  for(int i=0;i<9;i++){
+    if(b1[i]==0)return 0;
+  }
+  return 1;
+}
+
+int main(){
+  int s[9][9];
+  while(cin>>s[0][0]){
+    int c[9],count=0;
+    bool t1=true;
+    for(int i=1;i<9;i++)cin>>s[0][i];
+    for(int i=1;i<9;i++){
+      for(int j=0;j<9;j++)cin>>s[i][j];
+    }
+    for(int i=0;i<9 && t1==1;i++){
+      for(int j=0;j<9 && t1==1;j++){
+        c[j]=s[i][j];
+      }
+      t1=sudoku_check(c);
+      //cout<<++count<<" check = "<<t1<<endl;
+    }
+    for(int i=0;i<9 && t1==1;i++){
+      for(int j=0;j<9 && t1==1;j++){
+        c[j]=s[j][i];
+      }
+      t1=sudoku_check(c);
+      //cout<<++count<<" check = "<<t1<<endl;
+    }
+    for(int i=0;i<3 && t1==1;i++){
+      for(int j=0;j<3 && t1==1;j++){
+        int count1=0;
+        for(int k=i*3;k<(i+1)*3 && t1==1;k++){
+          for(int l=j*3;l<(j+1)*3 && t1==1;l++){
+            c[count1]=s[k][l];
+            count1++;
+          }
+        }
+        t1=sudoku_check(c);
+        //cout<<++count<<" check = "<<t1<<endl;
+      }
+    }
+    if(t1)cout<<"yes"<<endl;
+    else cout<<"no"<<endl;
+
+    /*for(int i=0;i<9;i++){
+      for(int j=0;j<9;j++){
+        cout<<s[i][j];
+      }
+    cout<<endl;
+    }*/
+  }
+  //system("pause");
+}
