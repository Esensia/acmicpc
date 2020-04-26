#include<iostream>
#include<queue>
 
#define endl "\n"
using namespace std;
 
int N, ans;
int MAP[12][12];
int visited[12];
int connected(int visited[]);

void dfs(int count, int dx){
    if(count >N){
        return;
    }
    if(count>0){
        int min = connected(visited);
        if(min!=-1 && ans >min){
            ans = min;
        }
    }
    for(int i=dx;i<=N;i++) {
        if(visited[i]==0) {
            visited[i]=1;
            dfs(count+1,i);
            visited[i]=0;
        }
    }
}

int connected(int visited[]){
    int backup[12];
    int backup2[12];
    queue<int> que1;
    queue<int> que2;
    
    int cnt =0;
    int cnt2=0;
    int sum=0;
    int sum2=0;
    
    for(int i=1;i<=N;i++){
        backup[i] = visited[i];
        backup2[i]= !visited[i];
        
        if(backup[i]==0 && cnt ==0){
            que1.push(i);
            backup[i]=1;
            sum+=MAP[i][0];
            cnt++;
        }
        if(backup2[i]==0 && cnt2==0){
            que2.push(i);
            backup2[i]=1;
            sum2+=MAP[i][0];
            cnt2++;
        }
    }
    while(que1.empty()==0) {
        int v = que1.front();
        que1.pop();

        for(int i =1;i<=N;i++) {
            if(MAP[v][i]==1 && backup[i]==0) {
                que1.push(i);
                sum+=MAP[i][0];
                backup[i]=1;
            }
        }
    }

    while(que2.empty()==0) {
        int v = que2.front();
        que2.pop();

        for(int i =1;i<=N;i++) {
            if(MAP[v][i]==1 && backup2[i]==0) {
                que2.push(i);
                sum2+=MAP[i][0];
                backup2[i]=1;
            }
        }
    }
    
    for(int i=1;i<=N;i++) {
        if(backup[i]==0 || backup2[i]==0) {
            return -1;
        }
    }
    return abs(sum-sum2);
    
}
 
int main(void)
{
    cin >> N;
    ans = 9999999;
    for (int i = 1; i <= N; i++)
    {
        cin>> MAP[i][0];
    }
    for(int i=1;i<=N;i++){
        int M;
        cin >> M;
        for(int j=0;j<M;j++){
            int vertex;
            cin >> vertex;
            MAP[i][vertex]=1;
        }
    }
    dfs(0,1);
    if(ans == 9999999){
        ans = -1;
    }
    
    cout << ans << endl;
    return 0;
}
