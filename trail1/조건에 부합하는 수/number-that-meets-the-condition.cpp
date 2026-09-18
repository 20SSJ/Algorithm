#include <iostream>
using namespace std;

int main() {
    int A;
    cin >> A;
    for(int i = 1; i <= A; i++){
        int share = i / 8;
        int remainder = i % 7;
        if((i % 4 != 0 && i % 2 == 0) || (share % 2 == 0) || (remainder < 4)) continue;
        cout << i << " ";
    }
    return 0;
}