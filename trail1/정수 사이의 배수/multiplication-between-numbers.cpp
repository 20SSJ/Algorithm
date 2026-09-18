#include <iostream>
using namespace std;

int main() {
    int A, B, res, cnt;
    res = cnt = 0;
    cin >> A >> B;
    while(A <= B){
        if(A % 5 == 0 || A % 7 == 0){
            res += A;
            cnt++;
        }
        A++;
    }
    cout << fixed;
    cout << res << " ";
    cout.precision(1);
    cout << float(res) / cnt;
    return 0;
}