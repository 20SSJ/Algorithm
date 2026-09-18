#include <iostream>
using namespace std;

int main() {
    int num, N, res = 0;
    cin >> N;
    while(N--){
        cin >> num;
        if(num % 2 != 0 && num % 3 == 0){
            res += num;
        }
    }
    cout << res;
    return 0;
}