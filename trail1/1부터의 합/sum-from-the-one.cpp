#include <iostream>
using namespace std;

int main() {
    int N, res = 0;
    cin >> N;
    for(int i = 1; i<= 100; i++){
        res += i;
        if(res >= N){
            cout << i;
            break;
        }
    }
    return 0;
}