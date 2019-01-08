#include<iostream>
using namespace std;

int main(){
    
    int N,M,K,i,j,x,y;
    
    cin >> N;
    cin >> M;
    
    int arr[301][301];
    int dp[301][301] = { 0, };
    for(i=1;i<=N;i++) {
        for(j=1;j<=M;j++) {
            cin >> arr[i][j];
            dp[i][j]=dp[i][j-1]+arr[i][j];
        }
    }
    cin >> K;
    
    while(K>=1) {
        
        cin >> i >> j >> x >> y;
        int num =0;
        int a=0;
        int b=0;
        for (int a = i ; a <= x; a++)
            num += dp[a][y] - dp[a][j - 1];
        cout << num << endl;
        
        K--;
        
    }
    
    return 0;
}

