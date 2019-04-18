#include<iostream>
#include<string.h>
using namespace std;

int dx[4]={-1,1,0,0};
int dy[4]={0,0,-1,1};

int M,N,K;
int arr[50][50]={0};
int visited[50][50]={0};

void dfs(int y,int x){
    
    for(int i=0;i<4;i++){
        int yy=y+dy[i];
        int xx=x+dx[i];
        
        if(yy<0 || yy>=N || xx<0 || xx>=M)
            continue;
        
        if(arr[yy][xx] && !visited[yy][xx]){
            visited[yy][xx]++;
            dfs(yy,xx);
        }
    }
}
int main(){
    int T,a,b;
    cin>>T;
    
    while(--T>=0){
        scanf("%d %d %d",&M,&N,&K);
        
        memset(arr,0,sizeof(arr));
        memset(visited,0,sizeof(visited));
        
        int count=0;
        
        for(int i=0;i<K;i++){
            scanf("%d %d",&a,&b);
            arr[b][a]=1;
        }
        
        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++)
                if(arr[i][j] && !visited[i][j]){
                    count++;
                    visited[i][j]++;
                    dfs(i,j);
                }
        
        cout<<count<<endl;
    }
    return 0;
}
