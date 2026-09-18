#include <iostream>
using namespace std;

int main() {
    int num, cnt, res;
    cnt = res = 0;
    for(int i = 0; i < 10; i++){
        cin >> num;
        if(num >= 0 && num <= 200){
            res += num;
            cnt++;
        }
    }
    cout << fixed;
    cout.precision(1);
    cout << res << " " << (float)res / cnt;
    return 0;
}