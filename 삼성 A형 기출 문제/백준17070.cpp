#include<iostream>
#include<queue>
 
#define endl "\n"
using namespace std;
 
int N, ans;
int MAP[20][20];
queue<pair<pair<int, int>, int > > que;

void BFS()
{
    while (que.empty() == 0)
    {
        int y = que.front().first.first;
        int x = que.front().first.second;
        int phase = que.front().second;
        que.pop();
 
        if (x == N - 1 && y == N - 1)
        {
            ans++;
            continue;
        }
 
        if (phase == 0)
        {
            int nx = x + 1;
            int ny = y;
            if (MAP[ny][nx]==0 && nx < N && ny < N)
            {
               que.push(make_pair(make_pair(ny, nx), 0));
                
            }
 
            ny = y+1;
            if (MAP[ny][nx]==0 && nx < N && ny < N && MAP[y+1][x]==0 && MAP[y][x+1]==0)
            {
                
                que.push(make_pair(make_pair(ny, nx), 2));
                
            }
        }
        if (phase == 1)
        {
            int nx = x;
            int ny = y + 1;
            if (MAP[ny][nx] ==0 && nx < N && ny < N)
            {
                que.push(make_pair(make_pair(ny, nx), 1));
                
            }
 
            nx = x + 1;
            if (MAP[ny][nx] == 0 && MAP[y][x+1] == 0 && MAP[y+1][x] == 0 && nx < N && ny < N)
            {
                que.push(make_pair(make_pair(ny, nx), 2));
                
            }
        }
        if (phase == 2)
        {
            int nx = x + 1;
            int ny = y;
            if (MAP[ny][nx] ==0 && nx < N && ny < N)
            {
                que.push(make_pair(make_pair(ny, nx), 0));
                
            }
            ny = y + 1;
                if (MAP[ny][nx]==0 && MAP[y][x+1] == 0 && MAP[y+1][x] == 0 && nx < N  && ny < N)
                {
 
                    que.push(make_pair(make_pair(ny, nx), 2));
                    
                }
            
            nx = x;
            if (MAP[ny][nx] ==0 && nx < N && ny < N)
            {
                que.push(make_pair(make_pair(ny, nx), 1));
                
            }
        }
    }
}
 
int main(void)
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> MAP[i][j];
        }
    }
    
    que.push(make_pair(make_pair(0, 1), 0));
    BFS();
    cout << ans << endl;
    return 0;
}
