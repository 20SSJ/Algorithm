#include <iostream>
#include <algorithm>
using namespace std;

int n, t;
pair<int, int> p[100001];
int main(){
    cin.tie(0); cout.tie(0);
    ios_base::sync_with_stdio(0);
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> p[i].second >> p[i].first;
    }
    int cnt = 0;
    int t = 0;
    sort(p, p+n);
    for(int i = 0; i < n; i++){
        if(t > p[i].second) continue;
        cnt++;
        t = p[i].first;
    }
    cout << cnt;
    return 0;
}