#include <stdio.h>
#include <iostream>
using namespace std;
// 為了實作方便，從陣列的第1格開始存入序列。
int s1[7+1] = {0, 2, 5, 7, 9, 3, 1, 2};
int s2[5+1] = {0, 3, 5, 3, 2, 8};
 
// DP 的表格
int array[7+1][5+1];
 
// 記錄這一格的最大值是從哪一格求得的
string prev[7+1][5+1];
 
void print_LCS(int i, int j)
{
    // 第一個或第二個 sequence 為空的的時候就可停止了
    if (i==0 || j==0) return;
 
    if (prev[i][j] == "左上方")
    {
        print_LCS(i-1, j-1);
        cout << s1[i];  // 印出 LCS 的元素
    }
    else if (prev[i][j] == "上方")
        print_LCS(i-1, j);
    else if (prev[i][j] == "左方")
        print_LCS(i, j-1);
}
void LCS(int s1_length, int s2_length)
{
    //將 array[x][0] 和 array[0][x] 都設為 0 ;
 
    for (int i = 1; i <= s1_length; i++)
        for (int j = 1; j <= s2_length; j++)
            if (s1[i] == s2[j])
            {
                // 這裡加上的 1 是指 e1 的長度為 1
                array[i][j] = array[i-1][j-1] + 1;
                prev[i][j] = "左上方";
            }
            else
            {
                if (array[i-1][j] < array[i][j-1])
                {
                    array[i][j] = array[i][j-1];
                    prev[i][j] = "左方";
                }
                else
                {
                    array[i][j] = array[i-1][j];
                    prev[i][j] = "上方";
                }
            }
 
    cout << "LCS 的長度是" << array[s1_length][s2_length];
 
    cout << "LCS 為 ";
    print_LCS(s1_length, s2_length);
}
 
int main(){
    LCS(7,5); 
}
