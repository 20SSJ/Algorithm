#include <iostream>
using namespace std;

int main() {
    int N, res = 0;
    cin >> N;
    while(N <= 100){
        res += N;
        N++;
    }
    cout << res;
    return 0;
}